package org.example.gofpatterns.builder;

public class PersonalComputer {
    //required params
    private String processor;
    private String graphicsCard;
    //optional params
    private int hddCapacity;
    private int ssdCapacity;
    private boolean isGraphicsCardBuiltInProcessor;

    private PersonalComputer(Builder builder) {
     this.processor = builder.processor;
     this.graphicsCard = builder.graphicsCard;
     this.hddCapacity = builder.hddCapacity;
     this.ssdCapacity = builder.ssdCapacity;
     this.isGraphicsCardBuiltInProcessor = builder.isGraphicsCardBuiltInProcessor;
    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "processor='" + processor + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", hddCapacity=" + (hddCapacity == 0 ? "no info" : hddCapacity) +
                ", ssdCapacity=" + (ssdCapacity == 0 ? "no info" : ssdCapacity) +
                ", isGraphicsCardBuiltInProcessor=" + isGraphicsCardBuiltInProcessor +
                '}';
    }

    public static class Builder {
        private String processor;
        private String graphicsCard;
        private int hddCapacity;
        private int ssdCapacity;
        private boolean isGraphicsCardBuiltInProcessor;
        public Builder(String processor, String graphicsCard) {
            this.processor = processor;
            this.graphicsCard = graphicsCard;
        }

        public Builder setHddCapacity(int hddCapacity) {
            this.hddCapacity = hddCapacity;
            return this;
        }

        public Builder setSsdCapacity(int ssdCapacity) {
            this.ssdCapacity = ssdCapacity;
            return this;
        }

        public Builder setGraphicsCardBuiltInProcessor(boolean graphicsCardBuiltInProcessor) {
            isGraphicsCardBuiltInProcessor = graphicsCardBuiltInProcessor;
            return this;
        }
        public PersonalComputer build() {
            return new PersonalComputer(this);
        }
    }

}
