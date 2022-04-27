import { Request, Response } from "express";
import { GetServerSidePropsContext } from "next";
import React from "react";
import { UserInfo } from "./constant";

export interface BaseRequest extends Request {
	customerInfo?: UserInfo;
	pathname?: string;
}

export interface BaseContext extends GetServerSidePropsContext {
	req: BaseRequest;
	res: Response;
}

export interface BaseProps { }

export const BaseContext = React.createContext<BaseProps>(undefined);
