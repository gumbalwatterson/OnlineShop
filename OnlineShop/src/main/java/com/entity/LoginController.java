package com.entity;




import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.apache.commons.codec.binary.CharSequenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {

	@Autowired
	UserService service;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IteamRepository iteamrepo;
	
	@GetMapping("/")
	public String homePage(Model model , Locale locale) throws UnsupportedEncodingException {
		User user = new User();
		model.addAttribute("iteams", service.getrandomiteams());
		model.addAttribute("user", user);
		model.addAttribute("loc", locale);
	/*
		Iteam iteam = new Iteam("dress", "Joe","no mes" );
			
		UsersMessages message1= new UsersMessages("hello ri timi bal abla bal", "Tom");
		UsersMessages message2= new UsersMessages("bal abla bal", "Erik");
		UsersMessages message3= new UsersMessages("hello im interested in", "Nick");
		
		iteam.getMessages().add(message1);
		iteam.getMessages().add(message2);
		iteam.getMessages().add(message3);
		
		iteamrepo.save(iteam);	
		*/
			return "index";
	}
	
	
	@GetMapping("/loginpage")
	public  String login(Model model) {
		model.addAttribute("user", new User());
			return "mylogin";
	}
	
	@GetMapping("/aboutpage")
	public  String getAboutPage(Model model) {
		model.addAttribute("user", new User());
			return "about";
	}
	
	
	@GetMapping("/cart")
	public  String getCartPage(Model model) {
		model.addAttribute("user", new User());
			return "cart";
	}
	
	
	 @RequestMapping(value ="/create" ,method= RequestMethod.POST)
	    public @ResponseBody User createNewUser(@RequestBody User user) {
	        return service.createUser(user);
	    }
	 
	 
	    @RequestMapping(value="/useraccount" , method=RequestMethod.GET)
	 public String successFullLogin(Model model , Authentication authentication) {
	    	MyUserDetails d =(MyUserDetails)authentication.getPrincipal();
	    //	MyUserDetails d =(MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 model.addAttribute("email", d.user.getEmail());
		 model.addAttribute("name", d.user.getName());
		 model.addAttribute("lastname", d.user.getLastname());
	
	    	return "useraccount";
	 }
	    
	    
		@RequestMapping(value = "/users", method = RequestMethod.GET)
		public @ResponseBody List<User> getAllUsers() {
			return service.findAll();
		}
	
		@RequestMapping(value="/test" , method= RequestMethod.GET)
		public String getTestPage(@RequestParam(name="seller") String selleremail,
								  @RequestParam(name="id") String id, 
								  Model model) {
		System.out.println(id);
			model.addAttribute("seller", service.finditeam(selleremail , Integer.parseInt(id)));
			return "productdetails";
		}

		
		// here are registering new user in database and sending 
		// confirmation email to the new logged user
		@RequestMapping(value="/regprocess" , method=RequestMethod.POST)
		public String registrationAction(@ModelAttribute @Valid User user, BindingResult result, Model model) throws Exception {
			
			System.out.println("in method regprocess");
			
			if(result.hasErrors()) {
				
				return "myregistration";
			}
			
			else if(service.checkIfExist(user.getEmail())!= null) {
			// check  logic would be for saving in user session some information
				// about already active state and checking that active state in user session
				System.out.println("exception happen " + user.getEmail());
				model.addAttribute("error", "true");
				
				return "myregistration";
			
				 
			}
			else {
				
			//password encoding and setting
			user.setPassword(encoder.encode(user.getPassword()));		
			//setting activation status
			user.setActive(0);
			//setting default permission
			user.setPermissions("USER");
			
			//  add new user to database
			service.createUser(user);
			
			String url2 ="click for registration";
			String url="http://localhost:8080/OnlineShop/regcom?param="+user.getEmail();
			String s = "<a href='"+url+"'>"+url2+"</a>";
			
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        
	        mailSender.setUsername("jankonto87@gmail.com");
	        mailSender.setPassword("password for jankonto@87gmail.com");
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        
	        helper.setFrom("jankonto87@gamil.com");
	        helper.setTo("gardur@o2.pl");
	        helper.setSubject("OnlineShope registration");
	        helper.setText(s, true);
			
	            

	        mailSender.send(message);
	        
	        /*
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("gardur@o2.pl");
	        message.setSubject("OnlineShope registration");
	        message.setFrom("enter email from which set message to gardur@o2.pl");
	        message.setText(s);
	        
	        mailSender.send(message);
				*/	
	        
	        return "success";
			}// end of else
		}
		
		@RequestMapping(value="/regcom")
		public String registrationConfirmation(@RequestParam(name="param") String email) {
			System.out.println(email);
		/*	
			if(service.checkIfExist(email)!= null) {
			// check  logic would be for saving in user session some information
				// about already active state and checking that active state in user session
				
			}
			*/
			service.changeActivationValue(email);
			System.out.println("done");
		return "registrationSuccess";
		
		}
		
		@RequestMapping(value="/registrationform" ,method=RequestMethod.GET)
		public String registrationForm(Model model) {
			User user =new User();
			model.addAttribute("user", user);
			
				return "myregistration";
		}
		
		@GetMapping("/search")
		public String searchBar(@RequestParam(name="find" ,defaultValue="def") String val , Model model) {
	
			if(val.equals("def")) {
		
		// if use not write anything in the search bar then we will be redirect to the same page
		return "redirect:/";
	}
			
	/*  else we will search for product in the database and if any results will be found
		we will display all this match products in the other page, searchresult page*/	
		
			List<Iteam> listofiteams = service.finditemas(val);
			for(Iteam i: listofiteams) {
				System.out.println(i.getItemname() + " " + i.getPrice() +" " + i.getId());
			}
			model.addAttribute("iteams", listofiteams);
			
			return "searchresult";
		}
		
		/*
		@GetMapping("/image")
		public void getimage(@RequestParam(name="n" , defaultValue="gumball") String productname , HttpServletResponse response) throws Exception {
			
			byte[] img =service.loadimage(productname);
			response.setContentType("image/png");
			ServletOutputStream outputstream =response.getOutputStream();
			outputstream.write(img);
			outputstream.close();
		
		}
		*/
		@PostMapping("/upload")
		public String uploadimage(@RequestParam("document") MultipartFile document,
				@RequestParam("iteam") String iteam ,
				@RequestParam("iteamdetail") String iteamdetail,
				@RequestParam("price") String price,				
				Authentication authentication ,
				RedirectAttributes redirectattributes) throws IOException {
			
			System.out.println("handling price " + price);
			System.out.println(StringUtils.cleanPath(document.getOriginalFilename()));
			String nameoffile =StringUtils.cleanPath(document.getOriginalFilename());
			String extension =nameoffile.substring(nameoffile.lastIndexOf(".")+1);
			System.out.println(extension);
			
			if(!extension.equals("jpg") && !extension.equals("png") ) {
				
				redirectattributes.addFlashAttribute("message", "only .jpg and .png files are allowed!");
				
				return "redirect:/useraccount";
			}
			
			BigDecimal p = new BigDecimal(price);
			
			
			MyUserDetails user = (MyUserDetails)authentication.getPrincipal();
			String selleremail = user.user.getEmail();
			String sellername =user.user.getName();
			
			byte[] content =document.getBytes();
			
			UsersMessages message = new UsersMessages("no_message", "empty", 1);
			Iteam i = new Iteam(sellername,iteam, content, p, selleremail, iteamdetail);
			i.getMessages().add(message);
			iteamrepo.save(i);
			
			redirectattributes.addFlashAttribute("message", "file uploaded succesfully");
			
			return "redirect:/useraccount";
			
		}
		
		@GetMapping("/collectionofiles")
		public String collectionfiles(@RequestParam("seller")String seller, Model model) {
			model.addAttribute("iteams", iteamrepo.findBySeller(seller));
		return "collectioniteams";
		
		}
		
		@PostMapping("/updateprice")
		public String updateprice(@RequestParam("price")String price,
								@RequestParam("seller")String seller ,
								@RequestParam("itemname")String itemname,
								@RequestParam("id")String id,
								Model model ,
								RedirectAttributes redirectattributes) {
			
			service.updatevalue(seller , price , itemname , id);
			redirectattributes.addFlashAttribute("message2", "iteam details updated");
			return "redirect:/useraccount";
		}
		
}
