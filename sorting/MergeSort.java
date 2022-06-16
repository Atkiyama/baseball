package baseball.sorting;

import java.util.ArrayList;
/**
 * ArrayListでマージソートを実装したクラス
 */

import baseball.Order;
import baseball.player.Player;

public class MergeSort extends Sort {
	/**
	 * 要素数を決めてマージソートを開始する
	 */

	@Override
	public void sort(ArrayList<Player> list, Order order) {
		// TODO 自動生成されたメソッド・スタブ
		// TODO 自動生成されたメソッド・スタブ
		int n = list.size();

		mergeSort(list, 0, n - 1, order);

	}
	/*
	 * 5cのときサイズが0で引数rightが-1になりBoundsOfExeption
	 */
/**
 * マージソートをするメソッド。要素を左右二つのリストに分け、その中で並び替えて元に戻してまた並べる。これを再起によりなんども繰り返してソートする
 * ここでは左右に分ける動作を行う
 * @param list ならべかえるリスト
 * @param left リストの最小の添字
 * @param rightリストの最大の添字
 * @param order 大小比較に使うメソッドを持ったクラスのオブジェクト
 */
	public void mergeSort(ArrayList<Player> list, int left, int right, Order order) {
		// TODO 自動生成されたメソッド・スタブ

		int mid = (left + right) / 2;
		ArrayList<Player> listL = new ArrayList<>();
		ArrayList<Player> listR = new ArrayList<>();

		if (left < mid)
			mergeSort(list, left, mid, order);
		//右半分に分けるために再起
		if (mid + 1 < right)
			mergeSort(list, mid + 1, right, order);
		//左半分に分けるために再起
		for (int i = 0; i <= mid - left; i++) {
				listL.add(list.get(i + left));
		}
		for (int j = 0; j < right - mid; j++) {
				listR.add(list.get(j + mid + 1));
		}

//ここで要素を結合、並び替えをする
		merge(listL, listR, list, left, order);

	}
/**
 * 要素を結合、並び替えするメソッド
 * @param listL 左半分のリス路
 * @param listR 右半分のリスト
 * @param list 並び替えるリスト
 * @param i listの何番目に値をセットするかを決める
 * @param order compareを使用するための参照型変数
 */
	public void merge(ArrayList<Player> listL, ArrayList<Player> listR, ArrayList<Player> list, int i,
			Order order) {
		// TODO 自動生成されたメソッド・スタブ
		int nl = listL.size();
		int nr = listR.size();
		int l = 0;
		int r = 0;
		while (l < nl && r < nr) {
			if (order.comparator(listR.get(r), listL.get(l)) >= 0)
				//listL.get(l) <= listR.get(r)
				list.set(i++, listL.get(l++));
			else
				list.set(i++, listR.get(r++));
		}
		while (l < nl)
			list.set(i++, listL.get(l++));
		while (r < nr)
			list.set(i++, listR.get(r++));

	}

}
