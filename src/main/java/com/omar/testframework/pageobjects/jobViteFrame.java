package com.omar.testframework.pageobjects;

/**
 * Created by omar on 7/5/16.
 */
public class jobViteFrame {

    public jobViteFrame() {
    }

    private String iframeJobViteIFrameId = "jobviteframe";
    private String buttonJobViteApplyXpath = "//*[@id=\"jvform\"]/div/div[1]/div[2]/div[3]/div[1]/a";
    private String buttonJobViteSubmitXpath = "//*[@id=\"jvform\"]/div/div[1]/div[2]/div[13]/input";
    private String textfieldJobViteNameId = "jvfirstname";
    private String buttonJobViteApplyWithResumeId = "jvApplyWithSection";
    private String buttonJobViteResumeChooseFileId = "File";
    private String buttonJobViteResumeSubmitXpath = "//*[@id=\"overlaydialog1\"]/form/div/div/div[2]/div[4]/input";
    private String iframeFileFrameId = "File1";
    private String textareaJobViteResumeFieldId = "jvresume";
    private String iframeJvResizeFrameId = "jvresize";

    public String getIframeJobViteIFrameId() {
        return iframeJobViteIFrameId;
    }

    public String getButtonJobViteApplyXpath() {
        return buttonJobViteApplyXpath;
    }

    public String getButtonJobViteSubmitXpath() {
        return buttonJobViteSubmitXpath;
    }

    public String getTextfieldJobViteNameId() {
        return textfieldJobViteNameId;
    }

    public String getButtonJobViteApplyWithResumeId() {
        return buttonJobViteApplyWithResumeId;
    }

    public String getButtonJobViteResumeChooseFileId() {
        return buttonJobViteResumeChooseFileId;
    }

    public String getButtonJobViteResumeSubmitXpath() {
        return buttonJobViteResumeSubmitXpath;
    }

    public String getIframeFileFrameId() {
        return iframeFileFrameId;
    }

    public String getTextareaJobViteResumeFieldId() {
        return textareaJobViteResumeFieldId;
    }

    public String getIframeJvResizeFrameId() {
        return iframeJvResizeFrameId;
    }
}
