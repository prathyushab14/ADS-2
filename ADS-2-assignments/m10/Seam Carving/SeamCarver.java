
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture pic;
	int w;
	int h;
	public SeamCarver(Picture picture) {
		pic = picture;
		this.w = picture.width();
		this.h = picture.height();
    }
	// current picture
	public Picture picture() {
		return pic;
	}
	// width of current picture
	public int width() {
        return w;
	}
    // height of current picture
	public int height() {
		return h;
	}
    // energy of pixel at column x and row y
	public double energy(int x, int y) {
	    if (x == 0 || y == 0 || x == pic.width() - 1 || y == pic.height() - 1) {
	    	return 1000;
	    }
	    double dx, dy = 0;
	    double xtred = pic.get(x - 1, y).getRed();
	    double xtblue = pic.get(x - 1, y).getBlue();
	    double xtgreen = pic.get(x - 1, y).getGreen();
	    double xbred = pic.get(x + 1, y).getRed();
	    double xbblue = pic.get(x + 1, y).getBlue();
	    double xbgreen = pic.get(x + 1, y).getGreen();
	    double yrred = pic.get(x, y - 1).getRed();
	    double yrblue = pic.get(x, y - 1).getBlue();
	    double yrgreen = pic.get(x, y - 1).getGreen();
	    double ylred = pic.get(x, y + 1).getRed();
	    double ylblue = pic.get(x, y + 1).getBlue();
	    double ylgreen = pic.get(x, y + 1).getGreen();
	    dx = Math.pow(xtred - xbred, 2) + Math.pow(xtblue - xbblue, 2) + Math.pow(xtgreen - xbgreen, 2);
	    dy = Math.pow(yrred - ylred, 2) + Math.pow(yrblue - ylblue, 2) + Math.pow(yrgreen - ylgreen, 2);
	    double esum = Math.sqrt(dx + dy);
	    return esum;
	}
    // sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}
    // sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}
    // remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}
    // remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}