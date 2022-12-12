//This class is currently not being used, Saved for future scope.
package com.datdyn.platform.maf.dtos;

import java.util.List;

public class PagedResponse<T> {
  private String link;
  private int totalCount;
  private int returnedCount;
  private List<T> listOfObjects;

  public String getLink() {
    return this.link;
  }

  public int getTotalCount() {
    return this.totalCount;
  }

  public int getReturnedCount() {
    return this.returnedCount;
  }

  public List<T> getAllElements() {
    return this.listOfObjects;
  }
}
