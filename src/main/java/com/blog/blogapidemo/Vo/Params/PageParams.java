package com.blog.blogapidemo.Vo.Params;

import lombok.Data;

@Data
public class PageParams {
    private int page=1;

    private int pageSize=10;
}
