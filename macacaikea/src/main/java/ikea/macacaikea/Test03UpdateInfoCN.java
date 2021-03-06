package ikea.macacaikea;

import com.alibaba.fastjson.JSONObject;
import macaca.client.MacacaClient;
import macaca.client.commands.Element;

public class Test03UpdateInfoCN {

	public static String browserName;
	public static String serverURL;
	public static int waitfortime;
	public static MacacaClient driver = new MacacaClient();

	// public static void main(String args[]) throws Exception {
	public void IKEA_UpdateIEPage() throws Exception {

		Logger.Output(LogType.LogTypeName.INFO, "测试用例03---open URL-UpdateMemberInfo-");
		serverURL = Propertyikea.URL_IKEA;
		waitfortime = Propertyikea.waitfortime;
		Logger.Output(LogType.LogTypeName.INFO, "The test server URL is: " + serverURL);

		JSONObject porps = new JSONObject();
		porps.put("browserName", "chrome");
		porps.put("platformName", "desktop");
		JSONObject desiredCapabilities = new JSONObject();
		desiredCapabilities.put("desiredCapabilities", porps);
		// desiredCapabilities.put("host", "127.0.0.1"); // custom remote host
		// desiredCapabilities.put("port", 3456); // custom remote port

		driver.initDriver(desiredCapabilities).get(serverURL);
		driver.maximize();

		// Logger.Output(LogType.LogTypeName.INFO, "Please confirm URL: " +
		// driver.currentContext().toString());

		// certification issue
		// driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		// Thread.sleep(1000);

		driver.frame("frame1");
		String updatetab = Propertyikea.updateInfoElement;
		String smscode = Propertyikea.smscode;
		Element updateinfo = driver.elementByXPath(updatetab);
		updateinfo.click();
		Logger.Output(LogType.LogTypeName.INFO, "----open update personal info Page---" + smscode);
		Thread.sleep(1000);

		driver.elementById("search_dialog").click();
		Thread.sleep(1000);
		Logger.Output(LogType.LogTypeName.INFO, "there popups a window: " + driver.alertText() + ".");
		driver.acceptAlert();

		Element name = driver.elementById("name");
		name.click();
		name.clearText();
		name.sendKeys(Propertyikea.username);
		Logger.Output(LogType.LogTypeName.INFO, "输入用户姓名: " + Propertyikea.username + ".");

		driver.elementById("search_dialog").click();
		Thread.sleep(1000);
		Logger.Output(LogType.LogTypeName.INFO, "there popups a window: " + driver.alertText() + ".");
		driver.acceptAlert();

		Element mobile = driver.elementById("mobile");
		mobile.click();
		mobile.clearText();
		mobile.sendKeys(Propertyikea.mobilenum);
		Logger.Output(LogType.LogTypeName.INFO, "输入手机号码: " + Propertyikea.mobilenum + ".");

		driver.elementById("search_dialog").click();
		Thread.sleep(1000);
		driver.setWaitElementTimeout(3);

		Thread.sleep(1000);

		Element validcode = driver.elementById("valid_code");
		validcode.click();
		validcode.clearText();
		validcode.sendKeys(Propertyikea.validcode);
		Logger.Output(LogType.LogTypeName.INFO, "输入validcode: " + Propertyikea.validcode + ".");

		driver.elementByXPath(".//div[2]/div[3]/div/button[1]/span").click();
		driver.setWaitElementTimeout(3);
		Thread.sleep(1000);
		// Element selectorzhuangxiu = driver.elementById("cst_rvi_id");
		// Select selectzz = new Select(selectorzhuangxiu);
		// selectzz.selectByValue("2");
		Element submitreg = driver.elementByLinkText("提交");
		Logger.Output(LogType.LogTypeName.INFO, ": " + "点击提交按钮" + ".");
		submitreg.click();
		Logger.Output(LogType.LogTypeName.INFO, "there popups a window: " + driver.alertText() + ".");
		driver.acceptAlert();

		Thread.sleep(9000);

		Logger.Output(LogType.LogTypeName.INFO, ": " + "更新会员信息成功" + ".");

	}

}
