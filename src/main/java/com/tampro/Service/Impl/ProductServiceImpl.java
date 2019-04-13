package com.tampro.Service.Impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tampro.DAO.ProductDAO;
import com.tampro.Entity.Product;
import com.tampro.Model.CategoryDTO;
import com.tampro.Model.MadeByDTO;
import com.tampro.Model.ProductDTO;
import com.tampro.Repository.ProductRepositoryImpl;
import com.tampro.Service.CategoryService;
import com.tampro.Service.MadeByService;
import com.tampro.Service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductDAO productDao;
	@Autowired
	CategoryService categoryser;
	@Autowired
	MadeByService madeSer;
	@Autowired
	ProductRepositoryImpl productRepo;

	@Override
	public ProductDTO getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = productDao.getProductById(id);
		ProductDTO productdto = new ProductDTO();
		productdto.setDescribe(product.getDescribe());
		productdto.setId(product.getId());
		productdto.setQuantity(product.getQuantity());
		productdto.setName(product.getName());
		productdto.setUrl(product.getUrl());
		productdto.setPrice(product.getPrice());
		CategoryDTO categorydto =categoryser.getCategoryById(product.getCategoryid());
		MadeByDTO madeByDTO = madeSer.getMadeByDTOId(product.getMadebyid());
		productdto.setMadeByDTO(madeByDTO);
		productdto.setCategoryDTO(categorydto);
		productdto.setDate(product.getDate());
		MultipartFile file   = new MultipartFile() {
			
			@Override
			public void transferTo(File dest) throws IOException, IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public long getSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getOriginalFilename() {
				// TODO Auto-generated method stub
				return product.getImage();
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public byte[] getBytes() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
		
		};
		productdto.setMultipartFile(file);
		
		return productdto;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> listProduct =productDao.getAllProduct();
		List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
		// TODO Auto-generated method stub
		for(Product product : listProduct) {
			ProductDTO productdto = new ProductDTO();
			productdto.setId(product.getId());
			productdto.setName(product.getName());
			productdto.setQuantity(product.getQuantity());
			productdto.setPrice(product.getPrice());
			productdto.setUrl(product.getUrl());
			productdto.setDescribe(product.getDescribe());
			productdto.setDate(product.getDate());
			CategoryDTO categorydto =categoryser.getCategoryById(product.getCategoryid());
			MadeByDTO madeByDTO = madeSer.getMadeByDTOId(product.getMadebyid());
			productdto.setMadeByDTO(madeByDTO);
			productdto.setCategoryDTO(categorydto);
			MultipartFile multi = new MultipartFile() {
				
				@Override
				public void transferTo(File dest) throws IOException, IllegalStateException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public long getSize() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public String getOriginalFilename() {
					// TODO Auto-generated method stub
					return product.getImage();
				}
				
				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public InputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getContentType() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public byte[] getBytes() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			};
			productdto.setMultipartFile(multi);
			listDTO.add(productdto);
			}
		return listDTO;
	}

	@Override
	public void addProductDTO(ProductDTO productdto) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setCategoryid(productdto.getCategoryDTO().getId());
		product.setDescribe(productdto.getDescribe());
		//product.setId(productdto.getId());
		product.setImage(productdto.getMultipartFile().getOriginalFilename());
		product.setMadebyid(productdto.getMadeByDTO().getId());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setQuantity(productdto.getQuantity());
		product.setUrl(productdto.getUrl());
		product.setDate(LocalDate.now().toString());
		productDao.addProduct(product);
	}

	@Override
	public void deleteProductDTO(int id) {
		// TODO Auto-generated method stub
		Product product = productDao.getProductById(id);
		productDao.deleteProduct(product);
	}

	@Override
	public void updateProductDTO(ProductDTO productdto) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setCategoryid(productdto.getCategoryDTO().getId());
		product.setDescribe(productdto.getDescribe());
		product.setId(productdto.getId());
		product.setUrl(productdto.getUrl());
		product.setImage(productdto.getMultipartFile().getOriginalFilename());
		product.setMadebyid(productdto.getMadeByDTO().getId());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setQuantity(productdto.getQuantity());
		product.setDate(productdto.getDate());
		productDao.updateProduct(product);
		
	}

	@Override
	public List<ProductDTO> getProductDTOByIdCategory(int idCategory) {
		List<Product> listProduct =productDao.getProductByIdCategory(idCategory);
		List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
		// TODO Auto-generated method stub
		for(Product product : listProduct) {
			ProductDTO productdto = new ProductDTO();
			productdto.setId(product.getId());
			productdto.setName(product.getName());
			productdto.setQuantity(product.getQuantity());
			productdto.setPrice(product.getPrice());
			productdto.setUrl(product.getUrl());
			productdto.setDescribe(product.getDescribe());
			productdto.setDate(product.getDate());
			CategoryDTO categorydto =categoryser.getCategoryById(product.getCategoryid());
			MadeByDTO madeByDTO = madeSer.getMadeByDTOId(product.getMadebyid());
			productdto.setMadeByDTO(madeByDTO);
			productdto.setCategoryDTO(categorydto);
			MultipartFile multi = new MultipartFile() {
				
				@Override
				public void transferTo(File dest) throws IOException, IllegalStateException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public long getSize() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public String getOriginalFilename() {
					// TODO Auto-generated method stub
					return product.getImage();
				}
				
				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public InputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getContentType() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public byte[] getBytes() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			};
			productdto.setMultipartFile(multi);
			listDTO.add(productdto);
			}
		return listDTO;
	}

	@Override
	public List<ProductDTO> get8ProductByDateNews() {
		List<Product> listProduct =productDao.get8ProductByDateNews();
		List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
		// TODO Auto-generated method stub
		for(Product product : listProduct) {
			ProductDTO productdto = new ProductDTO();
			productdto.setId(product.getId());
			productdto.setName(product.getName());
			productdto.setUrl(product.getUrl());
			productdto.setQuantity(product.getQuantity());
			productdto.setPrice(product.getPrice());
			productdto.setDescribe(product.getDescribe());
			productdto.setDate(product.getDate());
			CategoryDTO categorydto =categoryser.getCategoryById(product.getCategoryid());
			MadeByDTO madeByDTO = madeSer.getMadeByDTOId(product.getMadebyid());
			productdto.setMadeByDTO(madeByDTO);
			productdto.setCategoryDTO(categorydto);
			MultipartFile multi = new MultipartFile() {
				
				@Override
				public void transferTo(File dest) throws IOException, IllegalStateException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public long getSize() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public String getOriginalFilename() {
					// TODO Auto-generated method stub
					return product.getImage();
				}
				
				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public InputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getContentType() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public byte[] getBytes() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			};
			productdto.setMultipartFile(multi);
			listDTO.add(productdto);
			}
		return listDTO;
	}

	@Override
	public ProductDTO getProductDTOByUrl(String url) {
		Product product = productDao.getProductByUrl(url);
		ProductDTO productdto = new ProductDTO();
		productdto.setDescribe(product.getDescribe());
		productdto.setId(product.getId());
		productdto.setQuantity(product.getQuantity());
		productdto.setName(product.getName());
		productdto.setUrl(product.getUrl());
		productdto.setPrice(product.getPrice());
		CategoryDTO categorydto =categoryser.getCategoryById(product.getCategoryid());
		MadeByDTO madeByDTO = madeSer.getMadeByDTOId(product.getMadebyid());
		productdto.setMadeByDTO(madeByDTO);
		productdto.setCategoryDTO(categorydto);
		productdto.setDate(product.getDate());
		MultipartFile file   = new MultipartFile() {
			
			@Override
			public void transferTo(File dest) throws IOException, IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public long getSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getOriginalFilename() {
				// TODO Auto-generated method stub
				return product.getImage();
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public byte[] getBytes() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
		
		};
		productdto.setMultipartFile(file);
		
		return productdto;
	}

	@Override
	public int getQuantity(int idProduct) {
		// TODO Auto-generated method stub
		return productDao.getQuantity(idProduct);
	}

	
	

	

}
