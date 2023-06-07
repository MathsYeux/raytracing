public class GraphRaytracer {
    public static void main(String[] args) {
        String[] arguments = new String[]{"simple.txt", "512", "512"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "704", "480"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "1280", "720"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "1920", "1080"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "2560", "1440"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "4096", "2160"};
        LancerRaytracer.main(arguments);
        arguments = new String[]{"simple.txt", "7680", "4320"};
        LancerRaytracer.main(arguments);
        /*
        arguments = new String[]{"simple.txt", "15360", "8640"};
        LancerRaytracer.main(arguments);
        */
    }
}
