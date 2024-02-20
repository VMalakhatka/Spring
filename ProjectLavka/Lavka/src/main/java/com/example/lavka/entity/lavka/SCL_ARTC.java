package com.example.lavka.entity.lavka;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "SCL_ARTC", schema = "dbo", catalog = "Paint_Ua")
@NoArgsConstructor
public class SCL_ARTC {
    @Id
    private String COD_ARTIC; //COD_ARTIC
    private String NGROUP_TVR; //Группа
    private String NAME_ARTIC; //Название
    private double CENA_ARTIC;//Цена отпускная(руб.)
    private boolean PRIZN_VALT; //Признак расчета по валюте
    private double CENA_VALT; //Цена отпускная(вал)
    private String COD_VALT; //Код валюты
    private double NDS_ARTIC; //Торговая наценка
    private boolean NDS_TORGN; //Налог с торговой наценки
    private double NACH_KOLCH; //Начальное количество
    private double KON_KOLCH; //Фактический остаток
    private double REZ_KOLCH; //Свободный остаток
    private String EDIN_IZMER; //Единица измерения
    private double VES_EDINIC; //Вес единицы измерения
    private float EDN_V_UPAK; //Фасовка (кол. в упаковке)
    private double MIN_PARTIA; //Минимальная партия
    private double DLINA_ART; //Длина
    private double SHIRIN_ART;
    private double VYSOTA_ART;
    private String RAZM_IZMER; //Единица размера
    private String SCHET_ART;
    private String DOP1_ARTIC; //Примечание
    private String DOP2_ARTIC; //Поставщикpr
    private double UCHET_CENA; //Учетная цена
    private double UCHET_VALT; //Учетная цена(вал)
    private double UCHET_SUM; //Служебное поле 1
    private double UCHET_SMVL; //Служебное поле 2
    private double KOL_SUM;//Служебное поле 3
    private String NGROUP_TV2; //Подгруппа 1
    private double UCHET_0_C; //Учет руб. цена на начало
    private double NAL1_ART; //Налог1
    private double NAL2_ART; //Налог2
    private double UCHET_0_VL; //UCHET_0_VL
    private boolean FIX_NACEN; //Признак фиксир. наценки
    private float CENA_BZNAL; //Цена отп.(руб.) безнал
    private double CENA_V_BZN; //Цена отп(вал) безнал
    private String NGROUP_TV3; //Подгруппа 2
    private String NGROUP_TV4; //Подгруппа 3
    private String NGROUP_TV5; //Подгруппа 4
    private String NGROUP_TV6; //Подгруппа 5
    private boolean PRICE_LIST; //Признак вкл. в прайс-лист
    private String DOP3_ARTIC; //Описание
    private  double COEF_BZNAL; //Коэфф. безнала
    private String OKDP_ARTIC; //Код по ОКДП
    private double MIN_TVRZAP; //Мин товарный запас
    private  double MAX_TVRZAP; //Макс товарный запас
    private int ID_SCLAD; //Индекс склада
    private double  BALL1; //Балл1
    private double  BALL2; //Балл2
    private double  BALL3; //Балл3
    private double  BALL4; //Балл4
    private double  BALL5; //Балл5
    private int DEPARTAM; //Отдел
    private double NAL_PROD; //Налог с продаж
    private String TIP_TOVR; //Тип товара

    @OneToMany(mappedBy = "product" , cascade = CascadeType.REMOVE)
    private Set<SCL_MOVE> moveProduct;
}

