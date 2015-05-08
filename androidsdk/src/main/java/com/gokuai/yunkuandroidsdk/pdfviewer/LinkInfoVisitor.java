package com.gokuai.yunkuandroidsdk.pdfviewer;

abstract public class LinkInfoVisitor {
    public abstract void visitInternal(LinkInfoInternal li);

    public abstract void visitExternal(LinkInfoExternal li);

    public abstract void visitRemote(LinkInfoRemote li);
}