
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
		double[][] pathSum =new double[width()][height()];
		int[][] parent = new int[width()][height()];
		for(int i =0 ;i<height();i++){
			pathSum[0][i] = 1000;
			parent[0][i]=i;
		}
		for(int x= 1; x <width();x++){
			for(int y =0 ;y<height();y++){
				double tempSum =  pathSum[x-1][y];
				parent[x][y] = y;
				if(y>0 && pathSum[x-1][y-1] <tempSum){
					tempSum = pathSum[x-1][y-1];
					parent[x][y] = y-1;
				}
				if(y<height()-1 && pathSum[x-1][y+1] < tempSum){
					tempSum = pathSum[x-1][y+1];
					parent[x][y] = y+1;
				}
				pathSum[x][y]=tempSum+energy(x,y);
			}
		}
		int minIndex=0;

		for(int i = 1; i<height();i++){
			if(pathSum[width()-1][i] < pathSum[width()-1][minIndex]){
				minIndex = i;
			}
		}

		int res [] = new int[width()];
		res[width()-1] = minIndex;
		for (int h = width()-2;h>=0 ;h-- ) {
			//res[h] = parent[res[h+1]][h];	
			res[h]= parent[h+1][minIndex];
			minIndex=parent[h+1][minIndex];
		}
		return res;

		

		
	}
    // sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		double[][] pathSum =new double[width()][height()];
		int[][] parent = new int[width()][height()];
		for(int i =0 ;i<width();i++){
			pathSum[i][0] = 1000;
			parent[i][0]=i;
		}
		for(int y = 1; y <height();y++){
			for(int x =0 ;x<width();x++){
				double tempSum =  pathSum[x][y-1];
				parent[x][y] = x;
				if(x>0 && pathSum[x-1][y-1] <tempSum){
					tempSum = pathSum[x-1][y-1];
					parent[x][y] = x-1;
				}
				if(x<width()-1 && pathSum[x+1][y-1] <tempSum){
					tempSum = pathSum[x+1][y-1];
					parent[x][y] = x+1;
				}
				pathSum[x][y]=tempSum+energy(x,y);
			}
		}
		int minIndex=0;

		for(int i = 1; i<width();i++){
			if(pathSum[i][height()-1] < pathSum[minIndex][height()-1]){
				minIndex = i;
			}
		}

		int res [] = new int[height()];
		res[height()-1] = minIndex;
		for (int h = height()-2;h>=0 ;h-- ) {
			//res[h] = parent[res[h+1]][h];	
			res[h]= parent[minIndex][h+1];
			minIndex=parent[minIndex][h+1];
		}
		return res;

		//return new int[0];
	}
    // remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}
    // remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}