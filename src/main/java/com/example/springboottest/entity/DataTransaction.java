package com.example.springboottest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (DataTransaction)实体类
 *
 * @author makejava
 * @since 2019-07-23 15:43:56
 */

public class DataTransaction implements Serializable {
    private static final long serialVersionUID = 720182835355543092L;
    //路网号
    private String netno;
    //站编号
    private String siteno;
    //车道号
    private String laneno;
    //车道类型
    private String lanetype;
    //车道模式
    private String lanemode;
    
    private String cetc;
    //工作流水号
    private String jobno;
    //工作开始时间
    private Date jobbegin;
    //小队编号
    private String squadno;
    //工作人员编号
    private String staffno;
    //工作人员姓名
    private String staffname;
    //交易日期
    private Date transactiondate;
    //交易单流水号
    private String transactionno;
    //交易记录索引编号
    private String indxno;
    //车辆特情
    private String obstcsc;
    //付款方式
    private String obsmop;
    //收费操作
    private String obssequence;
    //车辆通行
    private String obspassage;
    //车型
    private String classno;
    //收费站netNo
    private String farenetno;
    //收费站siteNo
    private String faresiteno;
    //入口netNo
    private String entrynetno;
    //入口siteNo
    private String entrysiteno;
    //入口车道类型
    private String entrylanetype;
    //入口车道编号
    private String entrylaneno;
    //入口员工编号
    private String entrystaffno;
    //入口类别编号
    private String entryclassno;
    //入口车牌(识别)
    private String entryvehicleplate;
    //入口日期
    private Date entrydate;
    //入口工作编号
    private String entryjobno;
    //入口车种编号
    private String entrymopno;
    //收费方式编号
    private String mopno;
    //票号
    private String ticketno;
    //费率表版本
    private String faretblversion;
    //应收金额
    private Double prixtotal;
    //实收金额
    private Double prixpartial;
    //票据号+优惠/月票卡+计重菜单/模拟键操作标识
    private String mopdetail;
    //八进制代码
    private String codeoctal;
    //卡号
    private String tcscno;
    //卡版本号
    private String tcscversion;
    //盒号
    private String cartridgeno;
    //卡规则编号
    private String tcscorderno;
    //盒式循环号
    private String cartridgecycleno;
    //付款编号
    private String paycscno;
    //出口车牌识别
    private String exitvehicleplate;
    //出口车牌识别
    private String parvehicleplate;
    //处理类型
    private String processtype;
    
    private String coverweight;
    //发票类型
    private String invoicetype;
    //装备状态
    private String equipstatus;
    //上传标识
    private String cflag;
    //车型编号
    private String fareclassno;
    //班次编号
    private String shiftno;
    //图片文件
    private String imagefile;
    //线路编号
    private String routeno;
    //轴数
    private Double fareaxles;
    //检查重量
    private Double detectweight;
    //超重
    private Double overweight;
    //超重类型
    private String overweighttype;
    //入口车轴
    private String entryaxles;
    //入口重量
    private Double entryweight;
    //入口超重
    private Double entryoverweight;
    //入口超重类型
    private String entryoverweighttype;
    //入口车牌
    private String entryparvehicleplate;
    //图片注释
    private String picturecomment;
    //图片注释2
    private String picturecomment2;
    //重量模式
    private String weightmode;
    //车牌颜色
    private String parvehicleplatecolor;
    //里程
    private Double distance;
    //计算比率
    private Double computerate;
    //计重
    private Double fareweight;
    //超重票价
    private Double overweightfare;
    //轴组
    private Double axlegroups;
    
    private String axlegroup1type;
    
    private Double axlegroup1weight;
    
    private String axlegroup2type;
    
    private Double axlegroup2weight;
    
    private String axlegroup3type;
    
    private Double axlegroup3weight;
    
    private String axlegroup4type;
    
    private Double axlegroup4weight;
    
    private String axlegroup5type;
    
    private Double axlegroup5weight;
    
    private String axlegroup6type;
    
    private Double axlegroup6weight;
    
    private String axlegroup7type;
    
    private Double axlegroup7weight;
    
    private String axlegroup8type;
    
    private Double axlegroup8weight;
    
    private String axlegroup9type;
    
    private Double axlegroup9weight;
    //速度
    private Double speed;
    //加速度
    private Double acceleration;
    //车票价组类型
    private String fareaxlegroup1type;
    
    private String fareaxlegroup2type;
    
    private String fareaxlegroup3type;
    
    private String fareaxlegroup4type;
    
    private String fareaxlegroup5type;
    
    private String fareaxlegroup6type;
    
    private String fareaxlegroup7type;
    
    private String fareaxlegroup8type;
    
    private String fareaxlegroup9type;
    //超重时间
    private Date weightddhm;
    //轴入口组
    private Double entryaxlegroups;
    
    private String entryaxlegroup1type;
    
    private String entryaxlegroup2type;
    
    private String entryaxlegroup3type;
    
    private String entryaxlegroup4type;
    
    private String entryaxlegroup5type;
    
    private String entryaxlegroup6type;
    
    private String entryaxlegroup7type;
    
    private String entryaxlegroup8type;
    
    private String entryaxlegroup9type;
    
    private String picturecommenttype;
    //检查轴数
    private Double detectaxles;
    //是否超重
    private String isoverload;
    //是否特殊车
    private String isspecialtrunk;
    //限重
    private Double limitweight;
    
    private Double fareaxlegroup1weight;
    
    private Double fareaxlegroup2weight;
    
    private Double fareaxlegroup3weight;
    
    private Double fareaxlegroup4weight;
    
    private Double fareaxlegroup5weight;
    
    private Double fareaxlegroup6weight;
    
    private Double fareaxlegroup7weight;
    
    private Double fareaxlegroup8weight;
    
    private Double fareaxlegroup9weight;
    
    private Double entryaxlegroup1weight;
    
    private Double entryaxlegroup2weight;
    
    private Double entryaxlegroup3weight;
    
    private Double entryaxlegroup4weight;
    
    private Double entryaxlegroup5weight;
    
    private Double entryaxlegroup6weight;
    
    private Double entryaxlegroup7weight;
    
    private Double entryaxlegroup8weight;
    
    private Double entryaxlegroup9weight;
    
    private Double fareaxlegroups;
    //折扣票价
    private Double discountfare;
    //cpu卡网络号
    private String cpucardnetwork;
    //cpu卡编号
    private String cpucardno;
    //cpu卡类型00现金22储值卡23记账卡31扫码32无感
    private String cpucardtype;
    
    private Double flagstanum;
    
    private String flagsta;
    
    private Double byField1;
    //业务流水号
    private String qrtransid;
    //支付金额
    private String qrpayfare;
    //支付渠道01微信02支付宝03银联二维码04云闪付05人工确认单
    private String qrpaytype;
    //上传标志1
    private String cflag1;
    //上传标志2
    private String cflag2;
    //上传标识
    private String uploadflag;
    
    private String cflag3;


    public String getNetno() {
        return netno;
    }

    public void setNetno(String netno) {
        this.netno = netno;
    }

    public String getSiteno() {
        return siteno;
    }

    public void setSiteno(String siteno) {
        this.siteno = siteno;
    }

    public String getLaneno() {
        return laneno;
    }

    public void setLaneno(String laneno) {
        this.laneno = laneno;
    }

    public String getLanetype() {
        return lanetype;
    }

    public void setLanetype(String lanetype) {
        this.lanetype = lanetype;
    }

    public String getLanemode() {
        return lanemode;
    }

    public void setLanemode(String lanemode) {
        this.lanemode = lanemode;
    }

    public String getCetc() {
        return cetc;
    }

    public void setCetc(String cetc) {
        this.cetc = cetc;
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getJobbegin() {
        return jobbegin;
    }

    public void setJobbegin(Date jobbegin) {
        this.jobbegin = jobbegin;
    }

    public String getSquadno() {
        return squadno;
    }

    public void setSquadno(String squadno) {
        this.squadno = squadno;
    }

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getTransactionno() {
        return transactionno;
    }

    public void setTransactionno(String transactionno) {
        this.transactionno = transactionno;
    }

    public String getIndxno() {
        return indxno;
    }

    public void setIndxno(String indxno) {
        this.indxno = indxno;
    }

    public String getObstcsc() {
        return obstcsc;
    }

    public void setObstcsc(String obstcsc) {
        this.obstcsc = obstcsc;
    }

    public String getObsmop() {
        return obsmop;
    }

    public void setObsmop(String obsmop) {
        this.obsmop = obsmop;
    }

    public String getObssequence() {
        return obssequence;
    }

    public void setObssequence(String obssequence) {
        this.obssequence = obssequence;
    }

    public String getObspassage() {
        return obspassage;
    }

    public void setObspassage(String obspassage) {
        this.obspassage = obspassage;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getFarenetno() {
        return farenetno;
    }

    public void setFarenetno(String farenetno) {
        this.farenetno = farenetno;
    }

    public String getFaresiteno() {
        return faresiteno;
    }

    public void setFaresiteno(String faresiteno) {
        this.faresiteno = faresiteno;
    }

    public String getEntrynetno() {
        return entrynetno;
    }

    public void setEntrynetno(String entrynetno) {
        this.entrynetno = entrynetno;
    }

    public String getEntrysiteno() {
        return entrysiteno;
    }

    public void setEntrysiteno(String entrysiteno) {
        this.entrysiteno = entrysiteno;
    }

    public String getEntrylanetype() {
        return entrylanetype;
    }

    public void setEntrylanetype(String entrylanetype) {
        this.entrylanetype = entrylanetype;
    }

    public String getEntrylaneno() {
        return entrylaneno;
    }

    public void setEntrylaneno(String entrylaneno) {
        this.entrylaneno = entrylaneno;
    }

    public String getEntrystaffno() {
        return entrystaffno;
    }

    public void setEntrystaffno(String entrystaffno) {
        this.entrystaffno = entrystaffno;
    }

    public String getEntryclassno() {
        return entryclassno;
    }

    public void setEntryclassno(String entryclassno) {
        this.entryclassno = entryclassno;
    }

    public String getEntryvehicleplate() {
        return entryvehicleplate;
    }

    public void setEntryvehicleplate(String entryvehicleplate) {
        this.entryvehicleplate = entryvehicleplate;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getEntryjobno() {
        return entryjobno;
    }

    public void setEntryjobno(String entryjobno) {
        this.entryjobno = entryjobno;
    }

    public String getEntrymopno() {
        return entrymopno;
    }

    public void setEntrymopno(String entrymopno) {
        this.entrymopno = entrymopno;
    }

    public String getMopno() {
        return mopno;
    }

    public void setMopno(String mopno) {
        this.mopno = mopno;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getFaretblversion() {
        return faretblversion;
    }

    public void setFaretblversion(String faretblversion) {
        this.faretblversion = faretblversion;
    }

    public Double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(Double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Double getPrixpartial() {
        return prixpartial;
    }

    public void setPrixpartial(Double prixpartial) {
        this.prixpartial = prixpartial;
    }

    public String getMopdetail() {
        return mopdetail;
    }

    public void setMopdetail(String mopdetail) {
        this.mopdetail = mopdetail;
    }

    public String getCodeoctal() {
        return codeoctal;
    }

    public void setCodeoctal(String codeoctal) {
        this.codeoctal = codeoctal;
    }

    public String getTcscno() {
        return tcscno;
    }

    public void setTcscno(String tcscno) {
        this.tcscno = tcscno;
    }

    public String getTcscversion() {
        return tcscversion;
    }

    public void setTcscversion(String tcscversion) {
        this.tcscversion = tcscversion;
    }

    public String getCartridgeno() {
        return cartridgeno;
    }

    public void setCartridgeno(String cartridgeno) {
        this.cartridgeno = cartridgeno;
    }

    public String getTcscorderno() {
        return tcscorderno;
    }

    public void setTcscorderno(String tcscorderno) {
        this.tcscorderno = tcscorderno;
    }

    public String getCartridgecycleno() {
        return cartridgecycleno;
    }

    public void setCartridgecycleno(String cartridgecycleno) {
        this.cartridgecycleno = cartridgecycleno;
    }

    public String getPaycscno() {
        return paycscno;
    }

    public void setPaycscno(String paycscno) {
        this.paycscno = paycscno;
    }

    public String getExitvehicleplate() {
        return exitvehicleplate;
    }

    public void setExitvehicleplate(String exitvehicleplate) {
        this.exitvehicleplate = exitvehicleplate;
    }

    public String getParvehicleplate() {
        return parvehicleplate;
    }

    public void setParvehicleplate(String parvehicleplate) {
        this.parvehicleplate = parvehicleplate;
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }

    public String getCoverweight() {
        return coverweight;
    }

    public void setCoverweight(String coverweight) {
        this.coverweight = coverweight;
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getEquipstatus() {
        return equipstatus;
    }

    public void setEquipstatus(String equipstatus) {
        this.equipstatus = equipstatus;
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag;
    }

    public String getFareclassno() {
        return fareclassno;
    }

    public void setFareclassno(String fareclassno) {
        this.fareclassno = fareclassno;
    }

    public String getShiftno() {
        return shiftno;
    }

    public void setShiftno(String shiftno) {
        this.shiftno = shiftno;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno;
    }

    public Double getFareaxles() {
        return fareaxles;
    }

    public void setFareaxles(Double fareaxles) {
        this.fareaxles = fareaxles;
    }

    public Double getDetectweight() {
        return detectweight;
    }

    public void setDetectweight(Double detectweight) {
        this.detectweight = detectweight;
    }

    public Double getOverweight() {
        return overweight;
    }

    public void setOverweight(Double overweight) {
        this.overweight = overweight;
    }

    public String getOverweighttype() {
        return overweighttype;
    }

    public void setOverweighttype(String overweighttype) {
        this.overweighttype = overweighttype;
    }

    public String getEntryaxles() {
        return entryaxles;
    }

    public void setEntryaxles(String entryaxles) {
        this.entryaxles = entryaxles;
    }

    public Double getEntryweight() {
        return entryweight;
    }

    public void setEntryweight(Double entryweight) {
        this.entryweight = entryweight;
    }

    public Double getEntryoverweight() {
        return entryoverweight;
    }

    public void setEntryoverweight(Double entryoverweight) {
        this.entryoverweight = entryoverweight;
    }

    public String getEntryoverweighttype() {
        return entryoverweighttype;
    }

    public void setEntryoverweighttype(String entryoverweighttype) {
        this.entryoverweighttype = entryoverweighttype;
    }

    public String getEntryparvehicleplate() {
        return entryparvehicleplate;
    }

    public void setEntryparvehicleplate(String entryparvehicleplate) {
        this.entryparvehicleplate = entryparvehicleplate;
    }

    public String getPicturecomment() {
        return picturecomment;
    }

    public void setPicturecomment(String picturecomment) {
        this.picturecomment = picturecomment;
    }

    public String getPicturecomment2() {
        return picturecomment2;
    }

    public void setPicturecomment2(String picturecomment2) {
        this.picturecomment2 = picturecomment2;
    }

    public String getWeightmode() {
        return weightmode;
    }

    public void setWeightmode(String weightmode) {
        this.weightmode = weightmode;
    }

    public String getParvehicleplatecolor() {
        return parvehicleplatecolor;
    }

    public void setParvehicleplatecolor(String parvehicleplatecolor) {
        this.parvehicleplatecolor = parvehicleplatecolor;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getComputerate() {
        return computerate;
    }

    public void setComputerate(Double computerate) {
        this.computerate = computerate;
    }

    public Double getFareweight() {
        return fareweight;
    }

    public void setFareweight(Double fareweight) {
        this.fareweight = fareweight;
    }

    public Double getOverweightfare() {
        return overweightfare;
    }

    public void setOverweightfare(Double overweightfare) {
        this.overweightfare = overweightfare;
    }

    public Double getAxlegroups() {
        return axlegroups;
    }

    public void setAxlegroups(Double axlegroups) {
        this.axlegroups = axlegroups;
    }

    public String getAxlegroup1type() {
        return axlegroup1type;
    }

    public void setAxlegroup1type(String axlegroup1type) {
        this.axlegroup1type = axlegroup1type;
    }

    public Double getAxlegroup1weight() {
        return axlegroup1weight;
    }

    public void setAxlegroup1weight(Double axlegroup1weight) {
        this.axlegroup1weight = axlegroup1weight;
    }

    public String getAxlegroup2type() {
        return axlegroup2type;
    }

    public void setAxlegroup2type(String axlegroup2type) {
        this.axlegroup2type = axlegroup2type;
    }

    public Double getAxlegroup2weight() {
        return axlegroup2weight;
    }

    public void setAxlegroup2weight(Double axlegroup2weight) {
        this.axlegroup2weight = axlegroup2weight;
    }

    public String getAxlegroup3type() {
        return axlegroup3type;
    }

    public void setAxlegroup3type(String axlegroup3type) {
        this.axlegroup3type = axlegroup3type;
    }

    public Double getAxlegroup3weight() {
        return axlegroup3weight;
    }

    public void setAxlegroup3weight(Double axlegroup3weight) {
        this.axlegroup3weight = axlegroup3weight;
    }

    public String getAxlegroup4type() {
        return axlegroup4type;
    }

    public void setAxlegroup4type(String axlegroup4type) {
        this.axlegroup4type = axlegroup4type;
    }

    public Double getAxlegroup4weight() {
        return axlegroup4weight;
    }

    public void setAxlegroup4weight(Double axlegroup4weight) {
        this.axlegroup4weight = axlegroup4weight;
    }

    public String getAxlegroup5type() {
        return axlegroup5type;
    }

    public void setAxlegroup5type(String axlegroup5type) {
        this.axlegroup5type = axlegroup5type;
    }

    public Double getAxlegroup5weight() {
        return axlegroup5weight;
    }

    public void setAxlegroup5weight(Double axlegroup5weight) {
        this.axlegroup5weight = axlegroup5weight;
    }

    public String getAxlegroup6type() {
        return axlegroup6type;
    }

    public void setAxlegroup6type(String axlegroup6type) {
        this.axlegroup6type = axlegroup6type;
    }

    public Double getAxlegroup6weight() {
        return axlegroup6weight;
    }

    public void setAxlegroup6weight(Double axlegroup6weight) {
        this.axlegroup6weight = axlegroup6weight;
    }

    public String getAxlegroup7type() {
        return axlegroup7type;
    }

    public void setAxlegroup7type(String axlegroup7type) {
        this.axlegroup7type = axlegroup7type;
    }

    public Double getAxlegroup7weight() {
        return axlegroup7weight;
    }

    public void setAxlegroup7weight(Double axlegroup7weight) {
        this.axlegroup7weight = axlegroup7weight;
    }

    public String getAxlegroup8type() {
        return axlegroup8type;
    }

    public void setAxlegroup8type(String axlegroup8type) {
        this.axlegroup8type = axlegroup8type;
    }

    public Double getAxlegroup8weight() {
        return axlegroup8weight;
    }

    public void setAxlegroup8weight(Double axlegroup8weight) {
        this.axlegroup8weight = axlegroup8weight;
    }

    public String getAxlegroup9type() {
        return axlegroup9type;
    }

    public void setAxlegroup9type(String axlegroup9type) {
        this.axlegroup9type = axlegroup9type;
    }

    public Double getAxlegroup9weight() {
        return axlegroup9weight;
    }

    public void setAxlegroup9weight(Double axlegroup9weight) {
        this.axlegroup9weight = axlegroup9weight;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public String getFareaxlegroup1type() {
        return fareaxlegroup1type;
    }

    public void setFareaxlegroup1type(String fareaxlegroup1type) {
        this.fareaxlegroup1type = fareaxlegroup1type;
    }

    public String getFareaxlegroup2type() {
        return fareaxlegroup2type;
    }

    public void setFareaxlegroup2type(String fareaxlegroup2type) {
        this.fareaxlegroup2type = fareaxlegroup2type;
    }

    public String getFareaxlegroup3type() {
        return fareaxlegroup3type;
    }

    public void setFareaxlegroup3type(String fareaxlegroup3type) {
        this.fareaxlegroup3type = fareaxlegroup3type;
    }

    public String getFareaxlegroup4type() {
        return fareaxlegroup4type;
    }

    public void setFareaxlegroup4type(String fareaxlegroup4type) {
        this.fareaxlegroup4type = fareaxlegroup4type;
    }

    public String getFareaxlegroup5type() {
        return fareaxlegroup5type;
    }

    public void setFareaxlegroup5type(String fareaxlegroup5type) {
        this.fareaxlegroup5type = fareaxlegroup5type;
    }

    public String getFareaxlegroup6type() {
        return fareaxlegroup6type;
    }

    public void setFareaxlegroup6type(String fareaxlegroup6type) {
        this.fareaxlegroup6type = fareaxlegroup6type;
    }

    public String getFareaxlegroup7type() {
        return fareaxlegroup7type;
    }

    public void setFareaxlegroup7type(String fareaxlegroup7type) {
        this.fareaxlegroup7type = fareaxlegroup7type;
    }

    public String getFareaxlegroup8type() {
        return fareaxlegroup8type;
    }

    public void setFareaxlegroup8type(String fareaxlegroup8type) {
        this.fareaxlegroup8type = fareaxlegroup8type;
    }

    public String getFareaxlegroup9type() {
        return fareaxlegroup9type;
    }

    public void setFareaxlegroup9type(String fareaxlegroup9type) {
        this.fareaxlegroup9type = fareaxlegroup9type;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getWeightddhm() {
        return weightddhm;
    }

    public void setWeightddhm(Date weightddhm) {
        this.weightddhm = weightddhm;
    }

    public Double getEntryaxlegroups() {
        return entryaxlegroups;
    }

    public void setEntryaxlegroups(Double entryaxlegroups) {
        this.entryaxlegroups = entryaxlegroups;
    }

    public String getEntryaxlegroup1type() {
        return entryaxlegroup1type;
    }

    public void setEntryaxlegroup1type(String entryaxlegroup1type) {
        this.entryaxlegroup1type = entryaxlegroup1type;
    }

    public String getEntryaxlegroup2type() {
        return entryaxlegroup2type;
    }

    public void setEntryaxlegroup2type(String entryaxlegroup2type) {
        this.entryaxlegroup2type = entryaxlegroup2type;
    }

    public String getEntryaxlegroup3type() {
        return entryaxlegroup3type;
    }

    public void setEntryaxlegroup3type(String entryaxlegroup3type) {
        this.entryaxlegroup3type = entryaxlegroup3type;
    }

    public String getEntryaxlegroup4type() {
        return entryaxlegroup4type;
    }

    public void setEntryaxlegroup4type(String entryaxlegroup4type) {
        this.entryaxlegroup4type = entryaxlegroup4type;
    }

    public String getEntryaxlegroup5type() {
        return entryaxlegroup5type;
    }

    public void setEntryaxlegroup5type(String entryaxlegroup5type) {
        this.entryaxlegroup5type = entryaxlegroup5type;
    }

    public String getEntryaxlegroup6type() {
        return entryaxlegroup6type;
    }

    public void setEntryaxlegroup6type(String entryaxlegroup6type) {
        this.entryaxlegroup6type = entryaxlegroup6type;
    }

    public String getEntryaxlegroup7type() {
        return entryaxlegroup7type;
    }

    public void setEntryaxlegroup7type(String entryaxlegroup7type) {
        this.entryaxlegroup7type = entryaxlegroup7type;
    }

    public String getEntryaxlegroup8type() {
        return entryaxlegroup8type;
    }

    public void setEntryaxlegroup8type(String entryaxlegroup8type) {
        this.entryaxlegroup8type = entryaxlegroup8type;
    }

    public String getEntryaxlegroup9type() {
        return entryaxlegroup9type;
    }

    public void setEntryaxlegroup9type(String entryaxlegroup9type) {
        this.entryaxlegroup9type = entryaxlegroup9type;
    }

    public String getPicturecommenttype() {
        return picturecommenttype;
    }

    public void setPicturecommenttype(String picturecommenttype) {
        this.picturecommenttype = picturecommenttype;
    }

    public Double getDetectaxles() {
        return detectaxles;
    }

    public void setDetectaxles(Double detectaxles) {
        this.detectaxles = detectaxles;
    }

    public String getIsoverload() {
        return isoverload;
    }

    public void setIsoverload(String isoverload) {
        this.isoverload = isoverload;
    }

    public String getIsspecialtrunk() {
        return isspecialtrunk;
    }

    public void setIsspecialtrunk(String isspecialtrunk) {
        this.isspecialtrunk = isspecialtrunk;
    }

    public Double getLimitweight() {
        return limitweight;
    }

    public void setLimitweight(Double limitweight) {
        this.limitweight = limitweight;
    }

    public Double getFareaxlegroup1weight() {
        return fareaxlegroup1weight;
    }

    public void setFareaxlegroup1weight(Double fareaxlegroup1weight) {
        this.fareaxlegroup1weight = fareaxlegroup1weight;
    }

    public Double getFareaxlegroup2weight() {
        return fareaxlegroup2weight;
    }

    public void setFareaxlegroup2weight(Double fareaxlegroup2weight) {
        this.fareaxlegroup2weight = fareaxlegroup2weight;
    }

    public Double getFareaxlegroup3weight() {
        return fareaxlegroup3weight;
    }

    public void setFareaxlegroup3weight(Double fareaxlegroup3weight) {
        this.fareaxlegroup3weight = fareaxlegroup3weight;
    }

    public Double getFareaxlegroup4weight() {
        return fareaxlegroup4weight;
    }

    public void setFareaxlegroup4weight(Double fareaxlegroup4weight) {
        this.fareaxlegroup4weight = fareaxlegroup4weight;
    }

    public Double getFareaxlegroup5weight() {
        return fareaxlegroup5weight;
    }

    public void setFareaxlegroup5weight(Double fareaxlegroup5weight) {
        this.fareaxlegroup5weight = fareaxlegroup5weight;
    }

    public Double getFareaxlegroup6weight() {
        return fareaxlegroup6weight;
    }

    public void setFareaxlegroup6weight(Double fareaxlegroup6weight) {
        this.fareaxlegroup6weight = fareaxlegroup6weight;
    }

    public Double getFareaxlegroup7weight() {
        return fareaxlegroup7weight;
    }

    public void setFareaxlegroup7weight(Double fareaxlegroup7weight) {
        this.fareaxlegroup7weight = fareaxlegroup7weight;
    }

    public Double getFareaxlegroup8weight() {
        return fareaxlegroup8weight;
    }

    public void setFareaxlegroup8weight(Double fareaxlegroup8weight) {
        this.fareaxlegroup8weight = fareaxlegroup8weight;
    }

    public Double getFareaxlegroup9weight() {
        return fareaxlegroup9weight;
    }

    public void setFareaxlegroup9weight(Double fareaxlegroup9weight) {
        this.fareaxlegroup9weight = fareaxlegroup9weight;
    }

    public Double getEntryaxlegroup1weight() {
        return entryaxlegroup1weight;
    }

    public void setEntryaxlegroup1weight(Double entryaxlegroup1weight) {
        this.entryaxlegroup1weight = entryaxlegroup1weight;
    }

    public Double getEntryaxlegroup2weight() {
        return entryaxlegroup2weight;
    }

    public void setEntryaxlegroup2weight(Double entryaxlegroup2weight) {
        this.entryaxlegroup2weight = entryaxlegroup2weight;
    }

    public Double getEntryaxlegroup3weight() {
        return entryaxlegroup3weight;
    }

    public void setEntryaxlegroup3weight(Double entryaxlegroup3weight) {
        this.entryaxlegroup3weight = entryaxlegroup3weight;
    }

    public Double getEntryaxlegroup4weight() {
        return entryaxlegroup4weight;
    }

    public void setEntryaxlegroup4weight(Double entryaxlegroup4weight) {
        this.entryaxlegroup4weight = entryaxlegroup4weight;
    }

    public Double getEntryaxlegroup5weight() {
        return entryaxlegroup5weight;
    }

    public void setEntryaxlegroup5weight(Double entryaxlegroup5weight) {
        this.entryaxlegroup5weight = entryaxlegroup5weight;
    }

    public Double getEntryaxlegroup6weight() {
        return entryaxlegroup6weight;
    }

    public void setEntryaxlegroup6weight(Double entryaxlegroup6weight) {
        this.entryaxlegroup6weight = entryaxlegroup6weight;
    }

    public Double getEntryaxlegroup7weight() {
        return entryaxlegroup7weight;
    }

    public void setEntryaxlegroup7weight(Double entryaxlegroup7weight) {
        this.entryaxlegroup7weight = entryaxlegroup7weight;
    }

    public Double getEntryaxlegroup8weight() {
        return entryaxlegroup8weight;
    }

    public void setEntryaxlegroup8weight(Double entryaxlegroup8weight) {
        this.entryaxlegroup8weight = entryaxlegroup8weight;
    }

    public Double getEntryaxlegroup9weight() {
        return entryaxlegroup9weight;
    }

    public void setEntryaxlegroup9weight(Double entryaxlegroup9weight) {
        this.entryaxlegroup9weight = entryaxlegroup9weight;
    }

    public Double getFareaxlegroups() {
        return fareaxlegroups;
    }

    public void setFareaxlegroups(Double fareaxlegroups) {
        this.fareaxlegroups = fareaxlegroups;
    }

    public Double getDiscountfare() {
        return discountfare;
    }

    public void setDiscountfare(Double discountfare) {
        this.discountfare = discountfare;
    }

    public String getCpucardnetwork() {
        return cpucardnetwork;
    }

    public void setCpucardnetwork(String cpucardnetwork) {
        this.cpucardnetwork = cpucardnetwork;
    }

    public String getCpucardno() {
        return cpucardno;
    }

    public void setCpucardno(String cpucardno) {
        this.cpucardno = cpucardno;
    }

    public String getCpucardtype() {
        return cpucardtype;
    }

    public void setCpucardtype(String cpucardtype) {
        this.cpucardtype = cpucardtype;
    }

    public Double getFlagstanum() {
        return flagstanum;
    }

    public void setFlagstanum(Double flagstanum) {
        this.flagstanum = flagstanum;
    }

    public String getFlagsta() {
        return flagsta;
    }

    public void setFlagsta(String flagsta) {
        this.flagsta = flagsta;
    }

    public Double getByField1() {
        return byField1;
    }

    public void setByField1(Double byField1) {
        this.byField1 = byField1;
    }

    public String getQrtransid() {
        return qrtransid;
    }

    public void setQrtransid(String qrtransid) {
        this.qrtransid = qrtransid;
    }

    public String getQrpayfare() {
        return qrpayfare;
    }

    public void setQrpayfare(String qrpayfare) {
        this.qrpayfare = qrpayfare;
    }

    public String getQrpaytype() {
        return qrpaytype;
    }

    public void setQrpaytype(String qrpaytype) {
        this.qrpaytype = qrpaytype;
    }

    public String getCflag1() {
        return cflag1;
    }

    public void setCflag1(String cflag1) {
        this.cflag1 = cflag1;
    }

    public String getCflag2() {
        return cflag2;
    }

    public void setCflag2(String cflag2) {
        this.cflag2 = cflag2;
    }

    public String getUploadflag() {
        return uploadflag;
    }

    public void setUploadflag(String uploadflag) {
        this.uploadflag = uploadflag;
    }

    public String getCflag3() {
        return cflag3;
    }

    public void setCflag3(String cflag3) {
        this.cflag3 = cflag3;
    }

}