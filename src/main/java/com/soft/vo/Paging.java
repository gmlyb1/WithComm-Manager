package com.soft.vo;

public class Paging {
	
	private int page; // 현재 페이지 번호
    private int totalCount; // 전체 게시물 수
    private int startPage; // 시작 페이지 번호
    private int endPage; // 끝 페이지 번호
    private int prevPage; // 이전 페이지 번호
    private int nextPage; // 다음 페이지 번호
    private int displayPageNum = 10; // 화면에 보여지는 페이지 번호의 수
    private int perPageNum = 10; // 한 페이지당 보여지는 게시물의 수
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int perPageNum) {
        this.perPageNum = perPageNum;
    }

    private void calcData() {
        // 마지막 페이지 번호
        endPage = (int) (Math.ceil(page / (double) displayPageNum) * displayPageNum);
        
        // 시작 페이지 번호
        startPage = (endPage - displayPageNum) + 1;
        if (startPage < 1) {
            startPage = 1;
        }

        // 총 페이지 수
        int totalPage = (int) (Math.ceil(totalCount / (double) perPageNum));

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        // 이전 페이지 번호
        if (page <= displayPageNum) {
            prevPage = 1;
        } else {
            prevPage = ((page - 1) / displayPageNum) * displayPageNum;
        }

        // 다음 페이지 번호
        nextPage = (((page - 1) / displayPageNum) + 1) * displayPageNum;
        if (nextPage > totalPage) {
            nextPage = totalPage;
        }
        
        
    }
    
    
}
