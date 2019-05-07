package org.i9.xiaofang.service.repository.vo;

/**
 * 分页
 * 
 * @ClassName: PageListDto
 * @author: luobo
 * @date: 2018年9月11日 下午5:03:11
 */
public class PageListDto {

    private Integer pageSize;

    private Integer currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
