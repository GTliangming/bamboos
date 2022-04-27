export interface UserInfo {
	username: string;
}


interface Meta {
	cookie?: string;
	customerInfo?: UserInfo;
}

const meta: Meta = {
	cookie: "",
	customerInfo: undefined
};


export default class Constant {

	public static set cookie(cookie: string) {
		try {
			meta.cookie = cookie;
		} catch (e) {
			console.error(e);
		}
	}

	public static get cookie(): string {
		return meta.cookie;
	}

	public static set customerInfo(info: UserInfo) {
		try {
			meta.customerInfo = info;
		} catch (e) {
			console.error(e);
		}
	}

	public static get customerInfo(): UserInfo | undefined {
		return meta.customerInfo;
	}

}
