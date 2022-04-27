import React from "react";
import styled from "styled-components";

const Container = styled.div`
	display: flex;
	margin: 0 auto;
	padding-top: 20px;

	> div {
		height: 350px;
		background-color: #ffffff;
		padding: 80px;
		box-sizing: border-box;
		display: flex;
		justify-content: center;

		& > div {
			margin-left: 40px;

			& > h2 {
				color: #5e636c;
				font-size: 14px;
				font-weight: 600;
				line-height: 20px;
				margin-bottom: 20px;
			}

			& > a {
				height: 36px;
				line-height: 36px;
				margin-right: 20px;
				font-size: 14px;
			}
		}
	}
`;

interface ErrorPageProps {
	statusCode?: number;
}

const ErrorPage: React.FC<ErrorPageProps> = () => {
	return (
		<Container>
			<div>
				<div>
					<h2>数据获取失败</h2>
					{/* <Button theme="blue" onClick={() => Router.push("/")}>
						返回首页
					</Button> */}
				</div>
			</div>
		</Container>
	);
};
export default ErrorPage;
