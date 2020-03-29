package projlab.iceisland;

public class Skeleton {
    public static void called(Object obj, String name, String functionName, String args) {
        String type = obj.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+name+":"+type+"]."+functionName+"("+args+") - start");
    }

    public static void called(Object obj, String functionName, String args) {
        String type = obj.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+":"+type+"]."+functionName+"("+args+") - start");
    }

    public static void called(Enum e, String name, String functionName, String args) {
        //String value = e.toString();
        String type = e.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+name+":"+type+"]."+functionName+"("+args+") - start");
    }

    public static void returned(Object obj, String name, String functionName, String args) {
        String type = obj.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+name+":"+type+"]."+functionName+"("+args+") - end");
    }

    public static void returned(Object obj, String functionName, String args) {
        String type = obj.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+":"+type+"]."+functionName+"("+args+") - end");
    }

    public static void returned(Enum e, String name, String functionName, String args) {
        //String value = e.toString();
        String type = e.getClass().toString();
        type = type.substring(type.lastIndexOf(".") + 1);
        System.out.println("["+name+":"+type+"]."+functionName+"("+args+") - end");
    }
}
