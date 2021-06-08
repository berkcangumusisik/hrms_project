package kodlamaio.hrms.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.imageUploaders.CloudinaryService;
import kodlamaio.hrms.core.imageUploaders.ImageService;
@Configuration
public class Config {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dasioyw9j",
                "api_key", "155765191221993",
                "api_secret", "WKl1SSYWD9Zk0CGEYc3vwdVj66M"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryService();
    }
}