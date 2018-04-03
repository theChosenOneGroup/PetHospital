package base.model;

import base.util.JsonUtil;

/**
 * @author long
 * @since 18-3-31
 */
public class Page {

  private Integer page;

  private Integer pageSize;

  public Page(int page, int pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getPage() {
    return page;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public Integer getStart() {
    return page * pageSize;
  }

  public Integer getEnd() {
    return getStart() + pageSize;
  }

  @Override
  public String toString() {
    return JsonUtil.stringify(this);
  }
}
