package simplechatting2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestDto {
	private String resource;
	private String body;
}
