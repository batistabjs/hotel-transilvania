import axios from 'axios'

const url = `${process.env.VUE_APP_BASE_URL}checkins`;

export default {
    getAllCheckins: () => {
        return axios.get(url)
            .then((response) => response.data)
            .catch((error) => error)
    },
    saveCheckin: (checkin) => {
        return axios.post(url, checkin )
            .then((response) => response.data)
            .catch((error) => error)
    },
    searchCheckins: (select) => {
        return axios.get(`${url}/${select}`)
            .then((response) => response.data)
            .catch((error) => error)
    },
}

