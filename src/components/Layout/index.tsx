import React from "react";
import { UserInfo } from "utils/constant";
import { Footer, Nav, NavContent, NavItem } from "./common";
interface EzShipHeaderNav {
	title: string;
	link?: string;
	needLogin?: boolean;
	subs?: EzShipHeaderNav[];
	class?: string;
}

const navList = (): EzShipHeaderNav[] => {
	return [
		{
			title: "首页",
			link: "/",
		},
		{
			title: "测试",
			link: "/test",
			needLogin: true,
		},
		{
			title: "留言",
			link: "/order/new",
		},
		{
			title: "关于",
			link: "/order",
			needLogin: true,
		},
		{
			title: "我的",
			link: "/calculator",
		},
		{
			title: "设置",
			link: "/help/orderrelated/list",
		},
	];
}

interface LayoutProps {
	path: string;
	query: Record<string, string>;
	userInfo?: UserInfo;
	hideUser: boolean;
	language: string;
	isShowNav: boolean;
}

export default class Layout extends React.Component<LayoutProps> {
	static defaultProps = {
		showHeader: true,
		hideUser: false,
		isShowNav: false
	};
	jumpLink = (link: string) => {
		// if (!Constant.customerInfo) {
		// 	LoginAndRegisterModal.show({ language: this.props.language }, () => {
		// 		location.href = link;
		// 	});
		// } else {
		// 	location.href = link;
		// }
		location.href = link;
	}
	render() {
		const { children, isShowNav } = this.props;
		return (
			<div style={{ width: "100%" }}>
				{isShowNav && <Nav>
					<NavContent>
						{navList().map((item, index) => (
							<NavItem
								key={index}
							>
								<a {...(item.needLogin ? { onClick: () => this.jumpLink(item.link) } : { href: item.link })}>{item.title}</a>
							</NavItem>
						))}
					</NavContent>
				</Nav>}
				<main
					style={{ minHeight: !isShowNav ? "calc(100vh - 60px)" : undefined, marginTop: 60 }}
				>
					{children}
				</main>
				<Footer>
					<p>Copyright © 2021 www.ezbuy.com All Rights Reserved.</p>
				</Footer>
			</div >
		);
	}
}
