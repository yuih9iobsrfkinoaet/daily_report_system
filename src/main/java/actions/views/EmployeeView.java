package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//従業員情報についての画面入力の出力//

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //引数ありコンストラクタの生成

public class EmployeeView {
    //id
    private Integer id;

    //社員番号
    private String code;

    //氏名
    private String name;

    //パスワード
    private String password;

    //管理者権限の有無 なし:0 あり:1
    private Integer adminFlag;

    //登録日時
   private LocalDateTime createdAt;

   //更新日時
   private LocalDateTime updatedAt;

   //削除された従業員か区別 現役:0 削除済み:1
   private Integer deleteFlag;
}
