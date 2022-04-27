import { GetServerSideProps } from "next";
import withConstants from "utils/withConstants";
import Test from "views/test";


export const getServerSideProps: GetServerSideProps<Partial<{}>> = async () => {
    return {
        props: {
        }
    };
};
export default withConstants(Test);
