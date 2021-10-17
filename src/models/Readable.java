package models;

import enums.ProductLine;
package models.product;

import enums.ProductLine;
public class ReadableProduct {

        private String title;
        private String publisher;

        public ReadableProduct(int id, ProductLine line, String type, double eachPrice, int capacity, String title, String publisher) {
            super(id, line, type, eachPrice, capacity);
            this.title = title;
            this.publisher = publisher;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @Override
        public String toString() {
            return "Readable{" +
                    "id=" + super.getId() +
                    ", line=" + super.getLine() +
                    ", type='" + super.getType() + '\'' +
                    "title='" + title + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", eachPrice=" + super.getEachPrice() +
                    ", capacity=" + super.getCapacity() +
                    '}';
        }
    }

