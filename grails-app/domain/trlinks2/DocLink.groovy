package trlinks2

import grails.rest.Resource;

import javax.persistence.*;

/**
 * Created by gn3210hg on 10/14/15.
 */
@Resource(uri="/doclinks")
@Entity
@Table(name = "DOC_LINK", schema = "ISRSVAL", catalog = "")
public class DocLink {
    private int docLinkId;
    private String appPageName;
    private BigDecimal appPageSectionNbr;
    private String docTypeDesc;
    private String presentOrderCode;
    private String docLinkUrl;

    @Id
    @Column(name = "DOC_LINK_ID")
    public int getDocLinkId() {
        return docLinkId;
    }

    public void setDocLinkId(int docLinkId) {
        this.docLinkId = docLinkId;
    }

    @Basic
    @Column(name = "APP_PAGE_NAME")
    public String getAppPageName() {
        return appPageName;
    }

    public void setAppPageName(String appPageName) {
        this.appPageName = appPageName;
    }

    @Basic
    @Column(name = "APP_PAGE_SECTION_NBR")
    public BigDecimal getAppPageSectionNbr() {
        return appPageSectionNbr;
    }

    public void setAppPageSectionNbr(BigDecimal appPageSectionNbr) {
        this.appPageSectionNbr = appPageSectionNbr;
    }

    @Basic
    @Column(name = "DOC_TYPE_DESC")
    public String getDocTypeDesc() {
        return docTypeDesc;
    }

    public void setDocTypeDesc(String docTypeDesc) {
        this.docTypeDesc = docTypeDesc;
    }

    @Basic
    @Column(name = "PRESENT_ORDER_CODE")
    public String getPresentOrderCode() {
        return presentOrderCode;
    }

    public void setPresentOrderCode(String presentOrderCode) {
        this.presentOrderCode = presentOrderCode;
    }

    @Basic
    @Column(name = "DOC_LINK_URL")
    public String getDocLinkUrl() {
        return docLinkUrl;
    }

    public void setDocLinkUrl(String docLinkUrl) {
        this.docLinkUrl = docLinkUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocLink that = (DocLink) o;

        if (docLinkId != that.docLinkId) return false;
        if (appPageName != null ? !appPageName.equals(that.appPageName) : that.appPageName != null) return false;
        if (appPageSectionNbr != null ? !appPageSectionNbr.equals(that.appPageSectionNbr) : that.appPageSectionNbr != null)
            return false;
        if (docLinkUrl != null ? !docLinkUrl.equals(that.docLinkUrl) : that.docLinkUrl != null) return false;
        if (docTypeDesc != null ? !docTypeDesc.equals(that.docTypeDesc) : that.docTypeDesc != null) return false;
        if (presentOrderCode != null ? !presentOrderCode.equals(that.presentOrderCode) : that.presentOrderCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docLinkId;
        result = 31 * result + (appPageName != null ? appPageName.hashCode() : 0);
        result = 31 * result + (appPageSectionNbr != null ? appPageSectionNbr.hashCode() : 0);
        result = 31 * result + (docTypeDesc != null ? docTypeDesc.hashCode() : 0);
        result = 31 * result + (presentOrderCode != null ? presentOrderCode.hashCode() : 0);
        result = 31 * result + (docLinkUrl != null ? docLinkUrl.hashCode() : 0);
        return result;
    }
}
