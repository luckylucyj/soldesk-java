
package com.peisia.spring.seoul.pharmacy;

import java.util.List;

import lombok.Data;

@Data
public class TbPharmacyOperateInfo {

    public Integer list_total_count;
    public Result RESULT;
    public List<Row> row;

}
