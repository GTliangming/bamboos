import * as React from "react";
import hoistNonReactStatic from "hoist-non-react-statics";

import { BaseContext } from "./context";
import Constant from "./constant";

interface Props extends Constant {
	localeObj?: { [key: string]: string };
}
function withConstants<P extends Props>(WrapperComponent) {
	class WithTransPageComponent extends React.Component<P> {
		render() {
			return (
				<BaseContext.Provider
					value={{
						...this.props,
					}}
				>
					<WrapperComponent {...this.props} />
				</BaseContext.Provider>
			);
		}
	}
	return hoistNonReactStatic(WithTransPageComponent, WrapperComponent) as any;
}

export default withConstants;


