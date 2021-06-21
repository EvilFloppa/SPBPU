public final class CommonResource {

    private String info;

    CommonResource(String msg){
        this.info = msg;
    }

    public synchronized void setMsg(String msg){
        this.info = msg;
    }

    public synchronized String getMsg(){
        return info;
    }


}

