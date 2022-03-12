package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//従業員データのDTOクラス。//

    @Table(name = JpaConst.TABLE_EMP) //Table_EMPはテーブル名の定数。
    @NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_EMP_GET_ALL,
            query = JpaConst.Q_EMP_GET_ALL_DEF), //全ての従業員のidを降順に取得するクエリ
    @NamedQuery(
            name = JpaConst.Q_EMP_COUNT,
            query = JpaConst.Q_EMP_COUNT_DEF), //全ての従業員の件数を取得するクエリ
    @NamedQuery(
            name = JpaConst.Q_EMP_COUNT_RESISTERED_BY_CODE,
            query = JpaConst.Q_EMP_COUNT_RESISTERED_BY_CODE_DEF), //指定の社員番号をもつ社員の数を取得するクエリ
    @NamedQuery(
            name = JpaConst.Q_EMP_GET_BY_CODE_AND_PASS,
            query = JpaConst.Q_EMP_GET_BY_CODE_AND_PASS_DEF) //未削除の従業員を取得するクエリ

    })

@Getter //全てのクラスのフィールドのgetterをlombokで自動生成する。
@Setter //全てのクラスのフィールドのsetterをlombokで自動生成する。
@NoArgsConstructor //引数無しコンストラクタの自動生成。
@AllArgsConstructor //引数ありコンストラクタの自動生成。
@Entity
public class Employee {
        //id//
        @Id
        @Column(name = JpaConst.EMP_COL_ID)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        //社員番号//
        @Column(name = JpaConst.EMP_COL_CODE, nullable = false, unique = true)
        private String code;

        //氏名//
        @Column(name = JpaConst.EMP_COL_NAME, nullable = false)
        private String name;

        //パスワード//
        @Column(name = JpaConst.EMP_COL_PASS, length = 64, nullable = false)
        private String password;

        //管理者権限の区別。0:なし 1:あり//
        @Column(name = JpaConst.EMP_COL_ADMIN_FLAG, nullable = false)
        private Integer adminFlag;

        //登録日時
        @Column(name = JpaConst.EMP_COL_CREATED_AT, nullable = false)
        private LocalDateTime createdAt;

        //更新日時
        @Column(name = JpaConst.EMP_COL_UPDATED_AT, nullable = false)
        private LocalDateTime updatedAt;

        //削除済みの従業員か。0:在籍中。 1:削除済み
        @Column(name = JpaConst.EMP_COL_DELETE_FLAG, nullable = false)
        private Integer deleteFlag;
}

