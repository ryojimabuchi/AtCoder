package abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABC_054_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buff = null;
		buff = new BufferedReader(new InputStreamReader(System.in));

		String[] box = buff.readLine().split(" ");
		int N = Integer.parseInt(box[0]);

		String[] img = new String[ N ];
		int img_h = N;
		int img_w = 0;
		for (int i = 0; i < N; ++i) {
			img[i] = buff.readLine();
		}
		img_w = img[0].length();

		int h = 0;
		int w = 0;
		String[] pre_img = new String[ N ];
		String line = null;
		while ((line = buff.readLine()) != null) {
			if(line.equals("")){ break; }
			pre_img[h] = line;
			++h;
		}
		w = pre_img[0].length();
		boolean flag = false;

		for (int i = 0; i <= img_h - h; ++i) {
			for (int j = 0; j <= img_w - w; ++j) {

				int k = 0;
				int l = 0;

				for (k = 0; k < h; ++k) {
					for (l = 0; l < w; ++l) {
						if (img[i + k].charAt(j + l) != pre_img[k].charAt(l)) {
							break;
						}
					}
					if (l != w) {
						break;
					}
				}

				if (k == h && l == w) {
					flag = true;
					break;
				}
			}
		}

		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}

