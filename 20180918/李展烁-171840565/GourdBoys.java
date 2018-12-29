enum GourdBoys {
    老大("赤色"),老二("橙色"),老三("黄色"),老四("绿色"),老五("青色"),老六("蓝色"),老七("紫色");
    private String color;
    private GourdBoys(String color)
    {
        this.color = color;
    }

    public void report_name() { System.out.println(this.toString()+": "+this.toString()); }

    public void report_color(){
        System.out.println(this.toString()+":"+color);
    }

    public void report_change(int cur_pos, int nxt_pos){ System.out.println(this.toString()+": "+cur_pos+" -> "+nxt_pos); }


}
