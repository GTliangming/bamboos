import { IncomingMessage } from "http";
import { GetServerSidePropsContext, NextPageContext } from "next";
import { AppContext } from "next/app";
import { NextApiRequestCookies } from "next/dist/server/api-utils";
import { DocumentContext as OriginDocumentContext } from "next/document";
export interface BaseInfo {
	cookie: string;
}
export interface CustomRequest extends IncomingMessage {
	cookies: NextApiRequestCookies;
	pathname: string;
	baseInfo?: BaseInfo;
	// customerInfo?: UserInfo;
	renderStartTime?: number;
	renderPageName?: string;
}

export interface AppInitialContext extends NextPageContext {
	req: CustomRequest;
}

export interface AppInitialParams extends AppContext {
	ctx: AppInitialContext;
}
export interface ServerContext extends GetServerSidePropsContext {
	req: CustomRequest;
}
export interface DocumentContext extends OriginDocumentContext {
	req: CustomRequest;
}

export enum HeaderType {
	None,
	PureBack,
	MenuBack,
}
export interface PageStatic {
	I18N_NAMESPACE?: string[];
	TITLE?: string;
	HEADER_TYPE: HeaderType;
	BACK_FUNC: () => void;
	SHOW_NAV: boolean;
}