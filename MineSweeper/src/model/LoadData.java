package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoadData {

	private HashMap<String, BufferedImage> listImage;

	public LoadData() {
		listImage = new HashMap<String, BufferedImage>();

		try {
			BufferedImage img = ImageIO.read(new File("minesweeper.png"));

			listImage.put("title", img.getSubimage(0, 84, 114, 25));
			listImage.put("noUse", img.getSubimage(0, 39, 16, 16));
			listImage.put("co", img.getSubimage(16, 39, 16, 16));
			listImage.put("boomRed", img.getSubimage(32, 39, 16, 16));
			listImage.put("boomX", img.getSubimage(48, 39, 16, 16));
			listImage.put("boom", img.getSubimage(64, 39, 16, 16));
			listImage.put("b0", img.getSubimage(0, 23, 16, 16));
			listImage.put("b1", img.getSubimage(16, 23, 16, 16));
			listImage.put("b2", img.getSubimage(32, 23, 16, 16));
			listImage.put("b3", img.getSubimage(48, 23, 16, 16));
			listImage.put("b4", img.getSubimage(64, 23, 16, 16));
			listImage.put("b5", img.getSubimage(80, 23, 16, 16));
			listImage.put("b6", img.getSubimage(96, 23, 16, 16));
			listImage.put("b7", img.getSubimage(112, 23, 16, 16));
			listImage.put("b8", img.getSubimage(128, 23, 16, 16));
			listImage.put("smile", img.getSubimage(0, 55, 26, 26));
			listImage.put("smilePress", img.getSubimage(26, 55, 26, 26));
			listImage.put("smilePressPlay", img.getSubimage(52, 55, 26, 26));
			listImage.put("smileLose", img.getSubimage(78, 55, 26, 26));
			listImage.put("smileWin", img.getSubimage(104, 55, 26, 26));
			listImage.put("0", img.getSubimage(0, 0, 13, 23));
			listImage.put("1", img.getSubimage(13, 0, 13, 23));
			listImage.put("2", img.getSubimage(26, 0, 13, 23));
			listImage.put("3", img.getSubimage(39, 0, 13, 23));
			listImage.put("4", img.getSubimage(52, 0, 13, 23));
			listImage.put("5", img.getSubimage(65, 0, 13, 23));
			listImage.put("6", img.getSubimage(78, 0, 13, 23));
			listImage.put("7", img.getSubimage(91, 0, 13, 23));
			listImage.put("8", img.getSubimage(104, 0, 13, 23));
			listImage.put("9", img.getSubimage(117, 0, 13, 23));
			listImage.put("voCung", img.getSubimage(120, 0, 13, 23));
			listImage.put("tich", img.getSubimage(140, 49, 7, 7));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, BufferedImage> getListImage() {
		return listImage;
	}

	public void setListImage(HashMap<String, BufferedImage> listImage) {
		this.listImage = listImage;
	}

}
