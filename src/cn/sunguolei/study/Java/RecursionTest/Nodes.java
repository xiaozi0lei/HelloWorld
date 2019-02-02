package src.cn.sunguolei.study.Java.RecursionTest;

/**
 * @author GuoLei Sun
 * Date: 2018/11/27 10:07 AM
 */
public class Nodes {
    // 节点名称
    private String text;
    // 节点链接
    private String href;
    // 节点前置字体颜色
    private String color;
    // 节点是否可选、可点击
    private boolean selectable;
    // 树节点的下一级节点
    private Nodes[] nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public Nodes[] getNodes() {
        return nodes;
    }

    public void setNodes(Nodes[] nodes) {
        this.nodes = nodes;
    }
}
