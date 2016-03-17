package com.weebinar.jest;

public class MemberBean  {

	private String recommenderName = "";
	private String recommenderTree = "";
	private String recommenderId = "";

	private String id = "";
	private String password = "";
	private String saasId = "";
	private String name = "";
	private String nickName = "";
	private String imageEsId = "";
	private String vmLevel = "";
	private String esId = "";
	private String email = "";
	private String tree = "";
	private String shopId = "";
	private String shopName = "";
	private String phoneNumber = ""; 
	private String phoneLast4Number = "";
	private String isDelete = "N";
	private String readyVm = "N";
	private String gender = "";
	private String address = "";
	private String birthYear = "";
	private String birthMonth = "";
	private String birthDay = "";

	private String pushYn = "Y";
	private String season1User = "N";
	
	private long createDt = 0;
	private long lastLoginDt = 0;
	

	/** UserGradeType */
	private int grade; // 일반회원, 작업자회원.. ~~

	public MemberBean() {
		createDt = System.currentTimeMillis();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 010
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 0102767xxxxx
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreateDt() {
		return createDt;
	}

	public void setCreateDt(long createDt) {
		this.createDt = createDt;
	}

	public String getVmLevel() {
		return vmLevel;
	}

	public void setVmLevel(String vmLevel) {
		this.vmLevel = vmLevel;
	}

	public String getPhoneLast4Number() {
		return phoneLast4Number;
	}

	public void setPhoneLast4Number(String phoneLast4Number) {
		this.phoneLast4Number = phoneLast4Number;
	}

	public long getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(long lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSaasId() {
		return saasId;
	}

	public void setSaasId(String saasId) {
		this.saasId = saasId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEsId() {
		return esId;
	}

	public void setEsId(String esId) {
		this.esId = esId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecommenderName() {
		return recommenderName;
	}

	public void setRecommenderName(String recommenderName) {
		this.recommenderName = recommenderName;
	}

	public String getRecommenderId() {
		return recommenderId;
	}

	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId;
	}

	public String getRecommenderTree() {
		return recommenderTree;
	}

	public void setRecommenderTree(String recommenderTree) {
		this.recommenderTree = recommenderTree;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public String getImageEsId() {
		return imageEsId;
	}

	public void setImageEsId(String imageEsId) {
		this.imageEsId = imageEsId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void clear() {
		recommenderName = "";
		recommenderTree = "";
		recommenderId = "";
		id = "";
		password = "";
		saasId = "";
		name = "";
		nickName = "";
		imageEsId = "";
		vmLevel = "";
		esId = "";
		email = "";
		tree = "";
		phoneNumber = ""; // +8
		phoneLast4Number = "";
		lastLoginDt = 0;
		createDt = 0;
		shopId = "";
		shopName = "";
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getReadyVm() {
		return readyVm;
	}

	public void setReadyVm(String readyVm) {
		this.readyVm = readyVm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPushYn() {
		return pushYn;
	}

	public void setPushYn(String pushYn) {
		this.pushYn = pushYn;
	}

	public String getSeason1User() {
		return season1User;
	}

	public void setSeason1User(String season1User) {
		this.season1User = season1User;
	}

}
