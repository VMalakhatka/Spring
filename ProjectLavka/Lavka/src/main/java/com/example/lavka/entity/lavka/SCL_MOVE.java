package com.example.lavka.entity.lavka;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "SCL_MOVE", schema = "dbo", catalog = "Paint_Ua")
@NoArgsConstructor
public class SCL_MOVE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECNO")
    private short RECNO; // Индетификатор ключ
    @Column(name = "UNICUM_NUM")
    private long UNICUM_NUM; //Уникальный номер Это служебное поле
                            // - внутренний номер для связи с платежами
    @Column(name = "NUM_PREDMT")                        // и дан-ными о реквизитах документов
    private int NUM_PREDMT; //Порядковый номер товара в документе.
    @Column(name = "NAME_PREDM")
    private String NAME_PREDM; //Артикул товара, соответствующий артикулу этого товара
                                // в справочнике товаров, то есть значения
                                // Name_Predm (Scl_Move) и Cod_Artic (Scl_Artc) для
                                // одного товара должны совпадать.
    @Column(name = "KOLTREB_PR")
    private double KOLTREB_PR; //Требуемое количество
    @Column(name = "KOLC_PREDM")
    private double KOLC_PREDM; //Количество отпущенное
    @Column(name = "CENA_PREDM")
    private double CENA_PREDM; //Цена с нацен. и налогом
    @Column(name = "SUM_PREDM")
    private double SUM_PREDM; //Сумма
    @Column(name = "ORG_PREDM")
    private String ORG_PREDM; //Организация Краткое имя 'внешней' организации по документу,
                                // совпадает по значению с полем 'Кр.имя организации' в таблице
                                // реквизитов складских документов в строке с таким же уникальным
                                //номером, то есть
                                // Scl_Move.Org_Predm=Scl_Nakl.BriefOrg
                                // Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    // TODO какой формат правильный для этого поля?
    @Column(name = "DATE_PREDM")
    private Timestamp DATE_PREDM; //Дата движения товара - совпадает с датой документа в таблице
                                    // реквизи-тов в строке, соответствующей уникальному номеру.
                                    // Scl_Move.Date_Predm=Scl_Nakl.Date_P_Por
                                    //Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num
    @Column(name = "NUMDOCM_PR")
    private long NUMDOCM_PR; //Номер документа - Это номер ,который Вы присваиваете документу при вводе.
    // Система до-пускает несколько однотипных документов с одним и тем же номером..
    //Scl_Move.Numdocm_Pr=Scl_Nakl.N_Plat_Por
    //Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    @Column(name = "NUMDCM_DOP")
    private String NUMDCM_DOP; // Дополнительный номер док Дополнение к номеру документа
    // используется для идентификации разных документов с одним и тем же номером.
    //Scl_Move.Numdcm_Dop=Scl_Nakl.Dopn_Schet
    //Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    @Column(name = "TYPDOCM_PR")
    private char TYPDOCM_PR; // Тип документа, совпадающий с типом документа в таблице
//    Возможные значения : 'Р' - расходная накладная,
//                                        'П' - приходная накладная,
//                                        'C' - счет.
//    Если товар относится к накладной сборки:
//    то поле Typdocm_Pr='П', если количество в  накладной сборки положи-тельно
//    и  Typdocm_Pr='Р', если количество в  накладной сборки отрица-тельно
//    Scl_Move.Typdocm_Pr=Scl_Nakl.Type_Doc (<>'Б')
//    Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    @Column(name = "STND_UCHET")
    private boolean STND_UCHET; //  Установка признака 'учитывать' (Stnd_Uchet=1) и
    // 'не учитывать' (Stnd_Uchet=0)  в реквизитах документа позволяет управлять
    // отчетностью в системе, накладывая отбор по этому признаку на просмотр журналов,
    // реестров и отчетов.
    //    Значение поля переносится из таблицы реквизитов складских документов в таблицу
    //    движения товаров  для всех товаров, входящих в этот доку-мент.
    //    Scl_Move.Stdn_Uchet=Scl_Nakl.Stdn_Uchet
    //    Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    @Column(name = "NOT_NAL")
    private boolean NOT_NAL; //Этот признак позволяет получать отчетность отдельно для товаров,
    // опла-чиваемых через кассу (Not_Nal=1), и товаров, оплачиваемых через бан-ковский счет (Not_Nal=0).
//    Значение поля переносится из таблицы реквизитов складских документов в таблицу движения товаров
//    для всех товаров, входящих в этот доку-мент.
//    Scl_Move.Not_Nal=Scl_Nakl.Not_Nal
//    Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num

    @Column(name = "CONTRACT_N")
    private String CONTRACT_N; // Контракт Значение поля переносится из таблицы реквизитов складских документов
    // в таблицу движения товаров  для всех товаров, входящих в этот доку-мент.
//    Scl_Move.Contract_N=Scl_Nakl.Contr_Por
//    Where Scl_Move.Unicum_Num=Scl_Nakl.Unicum_Num
//    Значение этого поля можно использовать для отслеживания движения то-варов по конкретному контракту.

    @Column(name = "VALUT_CENA")
    private double VALUT_CENA; //Цена (валют)

    @Column(name = "COD_VALUT")
    private String COD_VALUT;

    @Column(name = "SUM_VALUT")
    private double SUM_VALUT; //Валютная сумма товара по документу с учетом налога.
    // Sum_Valut = Valut_Cena*Kolc_Predm (с заданной в 'настраиваемых пара-метрах' точностью).

    @Column(name = "NACENKA")
    private double NACENKA; //Наценка на базовую цену. Это общий процент наценки с учетом
    // наценок, скидок и дополнительных расходов данного документа. В случае скидки значение
    // процента должно быть отрицательным.

    @Column(name = "VALUTROUBL")
    private boolean VALUTROUBL; //Признак того, является ли документ, к которому относится данный
    // товар, валютным (ValutRoubl=0) или рублевым (ValutRoubl=1). Признак должен совпадать со
    //значением одноименного поля в таблице докумен-тов(Scl_Nacl)..

    @Column(name = "OPLATA_SCH")
    private boolean OPLATA_SCH; // Значение поля устанавливается в '1', если Kolc_Opl >= Kolc_Predm,
    // иначе значение поля равно '0'. То есть товар считается полностью оплаченным , когда количество
    // оплаченного товара не меньше количества товара по документу (независимо от суммы оплаты, так
    // как за период отсрочки пла-тежа может измениться курс или условия оплаты). Программа обращается
    // к корректировке этого поля в случае, когда устанавливается или снимает-ся признак оплаты документа,
    // а также при связывании платежного  доку-мента с накладной или его удалении.

    @Column(name = "NALOGMONEY")
    private double NALOGMONEY; //Сумма налогов в рублях, причем она уже учтена в Sum_Predm независи-мо
    // от способа вычисления налогов. Значение поля больше 0, если налог начисляется сверху, с минусом -
    // если налог в том числе. (При загрузке накладной из реестра проценты налогов берутся из справочника
    // товаров Scl_Artc (приоритет) и таблицы реквизитов складских документов Scl_Nakl).

    @Column(name = "NALOGVALUT")
    private double NALOGVALUT;

    @Column(name = "VOZVRAT_PR")
    private boolean VOZVRAT_PR;

    @Column(name = "SUM_UCHET")
    private double SUM_UCHET;

    @Column(name = "SUM_UCVAL")
    private double SUM_UCVAL;

    @Column(name = "KOLC_OPL")
    private double KOLC_OPL;

    @Column(name = "SUM_OPL")
    private double SUM_OPL;

    @Column(name = "SUMVAL_OPL")
    private double SUMVAL_OPL;

    @Column(name = "SUM_ROZN")
    private double SUM_ROZN;

    @Column(name = "OTMETKA")
    private boolean OTMETKA;

    @Column(name = "VID_DOC")
    private String VID_DOC;

    @Column(name = "PARTIA")
    private String PARTIA;

    // TODO какой формат правильный для этого поля?
    @Column(name = "SROK")
    private Timestamp SROK;

    @Column(name = "ID_SCLAD")
    private int ID_SCLAD;

    @Column(name = "BALL1")
    private double BALL1;

    @Column(name = "BALL2")
    private double BALL2;

    @Column(name = "BALL3")
    private double BALL3;

    @Column(name = "BALL4")
    private double BALL4;

    @Column(name = "BALL5")
    private double BALL5;

    @Column(name = "NAL_PR_RUB")
    private double NAL_PR_RUB;

    @Column(name = "NAL_PR_VAL")
    private double NAL_PR_VAL;

    @Column(name = "OS_OTM")
    private String OS_OTM;

    @ManyToOne
    @JoinColumn(name ="NAME_PREDM", referencedColumnName = "COD_ARTIC")
    private SCL_ARTC product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SCL_MOVE sclMove = (SCL_MOVE) o;
        return UNICUM_NUM == sclMove.UNICUM_NUM && NUM_PREDMT == sclMove.NUM_PREDMT && CENA_PREDM==sclMove.CENA_PREDM && NUMDOCM_PR == sclMove.NUMDOCM_PR && ID_SCLAD == sclMove.ID_SCLAD && Objects.equals(NUMDCM_DOP, sclMove.NUMDCM_DOP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UNICUM_NUM, NUM_PREDMT, CENA_PREDM, NUMDOCM_PR, NUMDCM_DOP, ID_SCLAD);
    }
}
