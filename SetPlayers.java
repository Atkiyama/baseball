package baseball;

import java.util.ArrayList;

import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;

/**
 * SetPlayersInterfaceの実装クラスです．
 */
public class SetPlayers implements SetPlayersInterface {

	/**
	 * Pitcherクラスのデータを管理するArrayListです．
	 */
	private ArrayList<Player> pitchers;

	/**
	 * Batterクラスのデータを管理するArrayListです．
	 */
	private ArrayList<Player> batters;

	/**
	 * ファイルに出力するPlayerを格納しておくArrayListです．
	 */
	private ArrayList<Player> selectedPlayers;

	/**
	 * 現在対象になっているリーグを格納します．
	 */
	private League league;

	/**
	 * 現在の対象がPitcherかBatterかを格納します．
	 */
	private PlayerType playerType;

	/**
	 * コンストラクタでは，フィールドleague，playerTypeを初期値のNONEに設定します．
	 */
	public SetPlayers() {
		league = League.NONE;
		playerType = PlayerType.NONE;
	}

	/**
	 * Pitcherのデータはフィールドpitchersへ，BatterのデータはフィールドBattersへ代入します．
	 */
	@Override
	public void scanPlayers(String pitcherFilename, String batterFilename) {
		batters = ScanPlayers.scanBatters(batterFilename);
		pitchers = ScanPlayers.scanPitchers(pitcherFilename);

	}

	/**
	 * ソート対象のLeagueまたはPlayerTypeが前回のソートから変わった場合は，selectedPlayersの読み直しをし，
	 * 対象のLeague, PlayerTypeの全Playerを格納するようにします．
	 */
	@Override
	public void setLeague(League league, PlayerType playerType) {
		//this.playerType=playerType;
		if (!this.league.equals(league)||!this.playerType.equals(playerType)) {
//limitを用いて消したデータが復元できていないためどんどんselectedPlayersから人が減っていく
			clearPlayers();
			this.playerType=playerType;
			this.league=league;
			//Pacificリーグかを判別
			boolean isPacific = true;
			if (!league.equals(League.PACIFIC))
				isPacific = false;
			copyLeaguePlayers(isPacific);

			//両方の場合にPACIFICもコピーする
			if (league.equals(League.BOTH))
				copyLeaguePlayers(true);

			if(!isBatter())
				for(Player batter:batters)
				selectedPlayers.remove(batter);
			else if(!isPitcher())
				for(Player pitcher:pitchers)
				selectedPlayers.remove(pitcher);




		}

	}

	/**
	 * 現在，Pitcherが対象になっているかを表します．
	 * @return playerTypeがBOTHまたはPITCHERならば，Pitcherが対象なのでtrueを戻します．
	 */
	public boolean isPitcher() {
		if (playerType.equals(PlayerType.BOTH) || playerType.equals(PlayerType.PITCHER))
			return true;
		else
			return false;

	}

	/**
	 * 現在，Batterが対象になっているかを表します．
	 * @return typeがBOTHまたはBATTERならば，Batterが対象なのでtrueを戻します．
	 */
	public boolean isBatter() {
		if (playerType.equals(PlayerType.BOTH) || playerType.equals(PlayerType.BATTER))
			return true;
		else
			return false;

	}

	/**
	 * selectedPlayersを初期化します．
	 */

	/**
	 * 一方のリーグのPlayerを，出力対象Playerを格納するArrayListにコピーします．
	 * @param isPacific trueならパシフィックリーグのPlayerのみ，falseならセントッルリーグのPlayerのみをコピーします．
	 */

	/**
	 * selectedPlayersのPlayerを，Orderに従ってソートします．
	 */
	@Override
	public void sort(Order order) {
		//System.out.println("ソート前\n"+selectedPlayers.size());
		order.sort(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult() {
		DumpPlayers.dumpPlayers(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult(String filename) {
		DumpPlayers.dumpPlayers(filename, selectedPlayers);
	}
/**
 * 然るべき要素をselectedPlayersにaddする
 * pacificとnoacificPを作りそれぞれポジションごとに代入後、isPacificにしたがってselectedPlayersに当てはまる方を代入する
 * @param isPacific　対象がPACIFICリーグならtrue
 */
	private void copyLeaguePlayers(boolean isPacific) {

		//pacificとnoacificPを作りそれぞれポジションごとに代入後、isPacificにしたがってselectedPlayersに当てはまる方を代入する
		ArrayList<Player> pacific = new ArrayList<>();
		ArrayList<Player> noPacific = new ArrayList<>();

			for (Player player : pitchers) {
				if (player.isPacific())
					pacific.add(player);
				else
					noPacific.add(player);

			}
			for (Player player : batters) {
				if (player.isPacific())
					pacific.add(player);
				else
					noPacific.add(player);

			}


		if (isPacific) {
			for (Player player : pacific)
				selectedPlayers.add(player);

		} else {
			for (Player player : noPacific)
				selectedPlayers.add(player);
		}


	}

	@Override
	/**
	 * selectedPlaayersを初期化する
	 */
	public void clearPlayers() {
		// TODO 自動生成されたメソッド・スタブ
		selectedPlayers = new ArrayList<>();
		league = League.NONE;
		playerType = PlayerType.NONE;


	}

}
