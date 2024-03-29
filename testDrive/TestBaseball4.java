package baseball.testDrive;

import java.util.ArrayList;

import baseball.Order;
import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;

/*
 * SortMethodの実装クラス,PlayerComparatorの実装クラスの
 * 動作確認のためのテストプログラム
 */
public class TestBaseball4 {

	public static void main(String[] args) {

		ArrayList<Player> aList1 = ScanPlayers.scanPitchers("pitchers.csv");
		Order.WIN.sort(aList1); // 勝利数順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_1.csv",aList1); // dumpPlayers(String, ArrayList)による出力

		Order.HP.sort(aList1); // ホールドポイント順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_2.csv",aList1); // dumpPlayers(String, ArrayList)による出力

		ArrayList<Player> aList2 = ScanPlayers.scanBatters("batters.csv");
		Order.HIT.sort(aList2); // 安打数順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_3.csv",aList2); // dumpPlayers(String, ArrayList)による出力

		Order.SLG.sort(aList2); // 長打率順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_4.csv",aList2); // dumpPlayers(String, ArrayList)による出力
	}
}
