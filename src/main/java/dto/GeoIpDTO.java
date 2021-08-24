package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GeoIpDTO {
	private String ip;
	private String countryName;
	private String cityName;
	private String postal;
	private String state;
	private String latitude;
	private String longitude;
	
	public GeoIpDTO(String ip, String countryName, String cityName, String postal, String state, String latitude,
			String longitude) {
		super();
		this.ip = ip;
		this.countryName = countryName;
		this.cityName = cityName;
		this.postal = postal;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
}
