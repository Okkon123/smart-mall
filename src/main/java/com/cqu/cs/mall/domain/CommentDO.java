package com.cqu.cs.mall.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CommentDO {
    /**
     * 主键id
     */
    private int id;
    /**
     * 评论用户id
     */
    @ExcelProperty("reviewerID")
    private String reviewerId;
    /**
     * 亚马逊标准识别码
     */
    @ExcelProperty("asin")
    private String asin;
    /**
     * 评论者姓名
     */
    @ExcelProperty("reviewerName")
    private String reviewerName;
    /**
     * 评论是否有帮助的数组数据
     */
    @ExcelProperty("helpful")
    private String helpful;
    /**
     * 评论文本内容
     */
    @ExcelProperty("reviewText")
    private String reviewText;
    /**
     * 评分，1-5
     */
    @ExcelProperty("overall")
    private int overall;
    /**
     * 总结
     */
    @ExcelProperty("summary")
    private String summary;
    /**
     * 评论unix时间戳
     */
    @ExcelProperty("unixReviewTime")
    private String unixReviewTime;
    /**
     * 评论时间
     */
    private String reviewTime;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
}
