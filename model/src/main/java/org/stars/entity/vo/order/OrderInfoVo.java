package org.stars.entity.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.stars.entity.model.order.OrderInfo;

@Data
public class OrderInfoVo extends OrderInfo {

	@ApiModelProperty(value = "课程id")
	private Long courseId;

	@ApiModelProperty(value = "课程名称")
	private String courseName;

	@ApiModelProperty(value = "课程封面图片路径")
	private String cover;

	@ApiModelProperty(value = "总时长:分钟")
	private Integer durationSum;

	@ApiModelProperty(value = "观看进度总时长:分钟")
	private Integer progressSum;

	@ApiModelProperty(value = "观看进度")
	private Integer progress;
}

