import javax.swing.JTextArea;

public class GameObject {
	private final int SCREEN_WIDTH=96;
	private final int SCREEN_HEIGHT=25;
	private final int LEFT_PADDING=2;
	private final int FIELD_WIDTH=70, FIELD_HEIGHT=25;
	private JTextArea textArea;
	protected char[][] buffer;
	private int field[];
	private int posX=30;
	private int posY=23;
	private String image=">-o-<";
	private String bPlane[]= new String[8];
	private int bposX=10;
	private int bposY=1;
	private String bimage="[XUX]";
	private int iposX=posX+2;
	private int iposY=posY-1;
	private String iimage="!";
	private boolean spaceb=false;
	
	public GameObject(JTextArea ta) {
		textArea =ta;
		field = new int[FIELD_WIDTH*FIELD_HEIGHT];
		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		initData();
	}
	
	
	public void initData() {
		for(int x=0; x<FIELD_WIDTH; x++)
		{
			for(int y=0; y<FIELD_HEIGHT; y++)
			{
				field[y*FIELD_WIDTH+x]= (x == 0 || x == FIELD_WIDTH - 1) ? 9 : 0;
			}
		}
		clearBuffer();
	}
	
	private void clearBuffer() {
		for(int y=0; y<SCREEN_HEIGHT; y++) {
			for(int x=0; x<SCREEN_WIDTH;x++) {
				buffer[x][y]='.';
			}
		}
	}
	
	private void drawToBuffer(int px, int py, String c) {
		for(int x=0; x<c.length(); x++) {
			buffer[px + x+ LEFT_PADDING][py] = c.charAt(x);

		}
	}
	
	private void drawToBuffer(int px, int py, char c) {
		buffer[px+ LEFT_PADDING][py] = c;
	}
	
	public void drawAll() {
		for(int x=0; x<FIELD_WIDTH; x++) {
			for (int y = 0; y < FIELD_HEIGHT; y++) {
				drawToBuffer(x, y, " ABCDEFG=#".charAt(field[y * FIELD_WIDTH + x]));
			}
		}
		
		drawScore(); 
		drawPlane();
		drawShoot();
		
		drawToBuffer(83,23,"by HaEun");
		render();
	}
	
	void drawPlane() {
		drawToBuffer(posX,posY,image);
		
		for(int i=0; i<2; i++) {
			for(int o=0; o<4; o++) {
				drawToBuffer(bposX+o*2*bimage.length()+(i*5),bposY+i*2,bimage);
			}
		}
	}
	
	void drawShoot() {
		if(spaceb) {
			for(iposY=posY-1;iposY>0; iposY--) {
				drawToBuffer(posX+2,iposY,iimage);
			}
			spaceb=false;
		}
	}
	
	
	private void drawScore() {
		drawToBuffer(FIELD_WIDTH +3, 1,  "忙式式式式式式式式式式式式式式式式忖");
		drawToBuffer(FIELD_WIDTH +3, 3,  "戌式式式式式式式式式式式式式式式式戎");
		drawToBuffer(FIELD_WIDTH +3, 2, "弛 SCORE: 0       弛" );
	}
	
	private void render() {
		StringBuilder sb=new StringBuilder();
		for(int y=0; y<SCREEN_HEIGHT; y++) {
			for(int x=0; x<SCREEN_WIDTH; x++) {
				sb.append(buffer[x][y]);
			}
			sb.append("\n");
		}
		textArea.setText(sb.toString());
	}
	
	void moveRightBlock() {
		if(posX>=(FIELD_WIDTH-6)) {
		}
		else {
			posX++;
			drawAll();
		}
	}
	
	void moveLeftBlock() {
		if(posX<=1) {
		}
		else {
			posX--;
			drawAll();
		}
	}
	
	void moveDownBlock() {
		if(posY>=FIELD_HEIGHT-1) {
		}
		else {
			posY++;
			drawAll();
		}
	}
	
	void moveUpBlock() {
		if(posY<=0) {
		}
		else {
			posY--;
			drawAll();
		}
	}
	
	void spaceBar() {
		spaceb=true;
		drawAll();
	}
	
	void moveRU() {
		if(posX>=(FIELD_WIDTH-6)&&posY<=0) {
		}
		else {
			posX++;
			posY--;
			drawAll();
		}
	}
	
	void moveRD() {
		if(posX>=(FIELD_WIDTH-6)&&posY>=FIELD_HEIGHT-1) {
		}
		else {
			posX++;
			posY++;
			drawAll();
		}
	}
	
	void moveLU() {
		if(posX<=1&&posY<=0) {
		}
		else {
			posX--;
			posY--;
			drawAll();
		}
	}
	
	void moveLD() {
		if(posX<=1&&posY>=FIELD_HEIGHT-1) {
		}
		else {
			posX--;
			posY++;
			drawAll();
		}
	}
	
	public static void main(String[] args) {

	}

}
