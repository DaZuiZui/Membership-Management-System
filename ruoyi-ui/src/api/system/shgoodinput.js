import request from '@/utils/request'

// 查询商品入库列表
export function listShgoodinput(query) {
  return request({
    url: '/system/shgoodinput/list',
    method: 'get',
    params: query
  })
}

// 查询商品入库详细
export function getShgoodinput(id) {
  return request({
    url: '/system/shgoodinput/' + id,
    method: 'get'
  })
}

// 新增商品入库
export function addShgoodinput(data) {
  return request({
    url: '/system/shgoodinput',
    method: 'post',
    data: data
  })
}

// 修改商品入库
export function updateShgoodinput(data) {
  return request({
    url: '/system/shgoodinput',
    method: 'put',
    data: data
  })
}

// 删除商品入库
export function delShgoodinput(id) {
  return request({
    url: '/system/shgoodinput/' + id,
    method: 'delete'
  })
}
