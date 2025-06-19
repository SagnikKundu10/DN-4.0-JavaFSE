public class BuilderPatternExample{

    static class Computer {
        private String cpu;
        private String ram;
        private String storage;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
        }

        public void showSpecs() {
            System.out.println("Computer Specs:");
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram);
            System.out.println("Storage: " + storage);
            System.out.println();
        }

        static class Builder {
            private String cpu;
            private String ram;
            private String storage;

            public Builder setCPU(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRAM(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel i3")
            .setRAM("4GB")
            .setStorage("256GB SSD")
            .build();

        basicComputer.showSpecs();

        
        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .build();

        gamingComputer.showSpecs();

        
        Computer cpuOnly = new Computer.Builder()
            .setCPU("AMD Ryzen 5")
            .build();

        cpuOnly.showSpecs();
    }
}
