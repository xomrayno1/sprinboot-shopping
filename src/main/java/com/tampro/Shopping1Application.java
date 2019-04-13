package com.tampro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.tampro.Entity.Product;
import com.tampro.Repository.ProductRepositoryImpl;
import com.tampro.Service.ProductService;

@SpringBootApplication
public class Shopping1Application  implements CommandLineRunner{

	@Autowired
	ProductService product;
	@Autowired
	ProductRepositoryImpl productRepository;
	public static void main(String[] args) {
		SpringApplication.run(Shopping1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				/*
				 *ALTER TABLE logtest CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
				 *https://stackoverflow.com/questions/1168036/how-to-fix-incorrect-string-value-errors
				 */
				
			/*	for(ProductDTO product : productService.get8ProductByDateNews()) {
					System.out.println("Name : "+product.getName()+"DATE : "+product.getDate()+"IMG : "+product.getMultipartFile().getOriginalFilename()+"ID :"+product.getId());
				}
				
				String redmi1 = "Xiaomi BlackShark 2 Ram 8Gb 256Gb";
				String url1 = "http://localhost:8080/" + URLEncoder.encode(redmi1, "UTF-8");
				
				System.out.println(url1);
				
				double vnd = 5000000;
				Locale locale = new Locale("vi","VN");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale);
				System.out.println(format.format(vnd));
				sout
				*/
				/*
				double vnd = 5000000;
				Locale locale = new Locale("vi","VN");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale); //double sang string
				System.out.println(format.format(vnd));
						
				Number num = format.parse(format.format(500000)); //string sang double
				// tao 1 bien kieu number , dung format de ep kieu sang numbe 
				System.out.println(num.doubleValue()); //lay ra number kieu double
				http://zetcode.com/java/numberformat/
				
				double vnd= 5500000;
				Locale locale = new Locale("vi","VN");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale);
				System.out.println(format.format(vnd));
				
				double vnd1= 13590000;
				
				
				System.out.println(format.format(vnd1));
				*/
				
				//System.out.println(key);
				//UserDTO userDTO = userser.getUserDTOByUsername("name2");
				//System.out.println(userDTO.getUserName()+":::"+userDTO.getPassWord());
				//UserDTO userDTO = new UserDTO("name2","user1","user1","user1","user1","user1","user1");
				//userser.addUserDTO(userDTO);
			
		// TODO Auto-generated method stub
		/*List<Product> list = productRepository.findAll();
		for(Product pro : list) {
			System.out.println(pro.getId());
		}
		
		Pageable pageable = PageRequest.of(0, 4);
		
		Page<Product> listpage = productRepository.findAll(pageable);
		for(Product pr : listpage) {
			System.out.println(pr.getId());
		}
		*/
		Pageable pageable1 = PageRequest.of(0, 3);
		//page 1 , size 4 
		// tu dong hieu page 0 se co 4 , tu 1-4 , 
		// va page 1 se tu 5-8 
		//Page<Product> listpage1 = productRepository.findAll(pageable1);
		
		//System.out.println("hop ly");
		//for(Product pr : listpage1) {
			//System.out.println(pr.getId());
		//}
		//System.out.println("tong so trang"+listpage1.getTotalPages());
		//listpage1.getTotalPages() nghia la voi so  page va size do thi no co the tao ra duoc bao nhiu total 
		Page<Product> listpage2 = productRepository.findByCategoryid(1,pageable1);
		for(Product pr : listpage2) {
			System.out.println(pr.getId()+pr.getName()+pr.getPrice());
		}		
		System.out.println(listpage2.getTotalPages());
		System.out.println(listpage2.getTotalElements());
		
		
	}

}
