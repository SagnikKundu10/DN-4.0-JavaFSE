public class ProxyPatternExample {

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from server: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            } else {
                System.out.println("Image already loaded. Using cached version.");
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");


        img1.display();

        System.out.println();


        img1.display();

        System.out.println();

        Image img2 = new ProxyImage("city.jpg");
        img2.display();
    }
}
