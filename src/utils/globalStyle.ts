import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
	html, body {
		margin: 0;
		display: flex;
		min-height: 100%;
		width: 100vw;
		font-size: 16px;
		max-width: 100vw;
		-webkit-overflow-scrolling: touch;
		-webkit-text-size-adjust: 100%;
		padding-bottom: constant(safe-area-inset-bottom);
		padding-bottom: env(safe-area-inset-bottom);
		#__next {
			display: flex;
			width: 100%;
		}
	}
	#launcher {
		display: none;
	}
	body.overflowHide {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
	}
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		font-family: SFProText-Regular, "Microsoft YaHei", "Open Sans", sans-serif, "Hiragino Sans GB", Arial, "Lantinghei SC", "5FAE8F6F96C59ED1", "STHeiti", "WenQuanYi Micro Hei", SimSun;
	}

	a {
		color: inherit;
		text-decoration: none;
	}
	header, section, footer, aside, nav, article, figure, details, main {
			display: block;
	}
	.disabledAutocomplete {
		position: fixed;
		top: -10px;
		left: -10px;
		width: 0;
		height: 0;
		opacity: 0;
		z-index: -1;
	}
`;