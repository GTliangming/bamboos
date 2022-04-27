/* eslint-disable */
import Document, { Html, Head, Main, NextScript } from "next/document";
import { ServerStyleSheet } from "styled-components";
import { BaseInfo, DocumentContext } from "utils/types";

interface CustomizeProps {
	baseInfo: BaseInfo;
}

class AntDocument extends Document<CustomizeProps> {
	static async getInitialProps(ctx: DocumentContext) {
		const sheet = new ServerStyleSheet();
		// 1.这里采用react里High Order Component的方式，可以重新包装APP和所有渲染的组件
		const originalRenderPage = ctx.renderPage;
		try {
			if (ctx.req) {
				ctx.req.renderStartTime = Date.now();
				ctx.req.renderPageName = ctx.pathname;
			}
			ctx.renderPage = () =>
				originalRenderPage({
					enhanceApp: (App) => (props) =>
						// App挂载样式
						sheet.collectStyles(<App {...props} />),
				});
			// 因为覆盖了Document，所以要重新返回页面的props
			const props = await Document.getInitialProps(ctx);
			const { baseInfo } = ctx?.req || {};

			return {
				...props,
				styles: (
					<>
						{props.styles}
						{sheet.getStyleElement()}
					</>
				),
				baseInfo,
			};
		} finally {
			sheet.seal();
		}
	}

	render() {
		const { baseInfo } = this.props;
		return (
			<Html>
				<Head>
					<meta name="full-screen" content="yes" />
					<meta name="apple-mobile-web-app-capable" content="yes" />
					<meta name="mobile-web-app-capable" content="yes" />
					<link rel="icon" href="/icon.ico" type="image/x-icon" />
					<link rel="apple-touch-icon" href="/icon.ico" type="image/x-icon" />
				</Head>
				<body>
					<Main />
					<script
						dangerouslySetInnerHTML={{
							__html: `(function(){
								if (/(iPhone\sOS)\s([\d_]+)/.test(navigator.userAgent)) {
									document.documentElement.style.fontSize = ((document.documentElement.clientWidth / 375) * 16) + "px";
								} else {
									document.documentElement.style.fontSize = ((window.innerWidth / 375) * 16) + "px";
								}
							})();`,
						}}
					/>
					<NextScript />
				</body>
			</Html>
		);
	}
}

export default AntDocument;
