public class MyPicture {

    /*
     * Fields or instance variables
     */
    private Picture picture; // basis that provides the extension of class Picture
    private String filename; // the name of the image file
    private int width;       // the image width
    private int length;      // the image length
    private String description; // the image description

    /* 
     * Constructor. 
     * Takes as a parameter the name of the file to load and a description of the picture.
     * The width and height of an image are available in the Picture class.
     */
    public MyPicture(String filename, String description) {
	// WRITE YOUR CODE HERE
    	picture = new Picture(filename);
    	this.filename = filename;
    	this.description = description;
    	width = picture.getWidth();
    	length = picture.getHeight();
    }

    /*
     * Returns the string representation for a MyPicture object.
     * The string's format should match the following EXACTLY:
     *       <imagename>.<extension> <width> x <length> <description>
     * Replace <xxx> with the respective data about this image
     */
    public String toString() {
	// WRITE YOUR CODE HERE
    	int x = filename.lastIndexOf("/");
    	int y = filename.lastIndexOf('\\');
    	int z = Math.max(x,y);
    	String representation = "";
    	representation = this.filename.substring(z+1) + " " + this.width + " x " + this.length + " " + this.description;
    	return representation;
    	
    }

    /* 
     * Returns true of the parameter MyPicture object is equal 
     * to the current instance, false otherwise. MyPicture objects 
     * are considered equal if and only if their filenames are the 
     * same AND their descriptions are the same.
     */
    public boolean equals(MyPicture p) {
	// WRITE YOUR CODE HERE
    	if (p == null) {
    		return false;
    	} else if (this.description.equals(p.description) && this.filename.equals(p.filename)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /* 
     * Returns a new Picture object representing the 'negative'
     * image of this MyPicture object. The negative of a pixel
     * is defined by taking each pixel's red, blue, and green value and
     * subtracting that value from 255.
     */
    public Picture negative () {
	// WRITE YOUR CODE HERE
    	Picture v = new Picture (width, length);
    	Pixel [] pixels = picture.getPixels();
    	Pixel [] pixels2 = v.getPixels();
    	for (int i = 0; i < pixels.length; i++) {
    		pixels2[i].setRed(255 - pixels[i].getRed());
    		pixels2[i].setBlue(255 - pixels[i].getBlue());
    		pixels2[i].setGreen(255 - pixels[i].getGreen());
    	}
    	return v;
    }

    /*
     * Returns the redness score of this image. 
     * The redness score is defined by the total number of pixels that have
     * a red value that is greater than both the blue and green
     * pixels divided by the total number of pixels
     */
    public double redness() {
	// WRITE YOUR CODE HERE
    	Pixel [] pixels = picture.getPixels();
    	double count = 0; 
    	double total = 0;
    	for (int i = 0; i < pixels.length; i++) {
    		if (pixels[i].getRed() > pixels[i].getBlue() && pixels[i].getRed() > pixels[i].getGreen()) {
    			count++;
    			total++;
    		} else {
    			total++;
    		}
    	}
    	return count/total;
    }

    /* 
     * Convert flipHorizontal from Part 1 to an instance method
     */
    public void flipHorizontal () {
	// WRITE YOUR CODE HERE
    	int x = 0;
    	while (x < width/2) {
    		for (int y = 0; y < length; y++) {
    			int color = picture.getBasicPixel(x, y);
    			picture.setBasicPixel(width-1-x, y, color);
    		}
    		x++;
    	}
    }

    /* 
     * Convert flipVertical from Part 1 to an instance method
     */
    public void flipVertical () {
	// WRITE YOUR CODE HERE
    	int x = 0;
    	while (x < width) {
    		for (int y = 0; y < length/2; y++) {
    			int color = picture.getBasicPixel(x, y);
    			picture.setBasicPixel(x, length-1-y, color);
    		}
    		x++;
    	}
    }
}